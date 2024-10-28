package cat.uvic.teknos.coursemanagement.services.controllers;

import cat.uvic.teknos.coursemanagement.domain.jpa.models.JpaCourse;
import cat.uvic.teknos.coursemanagement.models.Course;
import cat.uvic.teknos.coursemanagement.models.ModelFactory;
import cat.uvic.teknos.coursemanagement.repositories.RepositoryFactory;
import cat.uvic.teknos.coursemanagement.services.exception.ResourceNotFoundException;
import cat.uvic.teknos.coursemanagement.services.exception.ServerErrorException;
import cat.uvic.teknos.coursemanagement.services.utils.Mappers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CourseController implements Controller{
    private final RepositoryFactory repositoryFactory;
    private final ModelFactory modelFactory;
    private ObjectMapper mapper = new ObjectMapper();

    public CourseController(RepositoryFactory repositoryFactory, ModelFactory modelFactory) {
        this.repositoryFactory = repositoryFactory;
        this.modelFactory = modelFactory;
    }

    @Override
    public String get(int id) {
        var course  = repositoryFactory.getCourseRepository().get(id);

        try {
            return Mappers.get().writeValueAsString(course); // json
        } catch (JsonProcessingException e) {
            throw new ResourceNotFoundException();
        }
    }

    @Override
    public String get() {
        var students = repositoryFactory.getCourseRepository().getAll();

        try {
            return mapper.writeValueAsString(students);
        } catch (JsonProcessingException e) {
            throw new ResourceNotFoundException(e);
        }
    }

    @Override
    public void post(String json) {
        Course course = null;
        try {
            course = mapper.readValue(json, JpaCourse.class);
        } catch (JsonProcessingException e) {
            throw new ServerErrorException(e);
        }
        repositoryFactory.getCourseRepository().save(course);
    }

    @Override
    public void put(int id, String json) {

    }

    @Override
    public void delete(int id) {

    }
}
