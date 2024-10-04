package cat.uvic.teknos.coursemanagement.services.controllers;

import cat.uvic.teknos.coursemanagement.models.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StudentController implements Controller<Integer, Student>{
    @Override
    public String get(Integer integer) {
        // retrieve (get) student from db
        // serialize student in json format

        return ""; // json
    }

    @Override
    public String get() {
        return null;
    }

    @Override
    public void post(Student value) {

    }

    @Override
    public void put(Integer key, Student value) {

    }

    @Override
    public void delete(Integer key) {

    }
}
