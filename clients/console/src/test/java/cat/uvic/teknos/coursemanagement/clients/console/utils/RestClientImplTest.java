package cat.uvic.teknos.coursemanagement.clients.console.utils;

import cat.uvic.teknos.coursemanagement.clients.console.dto.CourseDto;
import cat.uvic.teknos.coursemanagement.clients.console.exceptions.RequestException;
import cat.uvic.teknos.coursemanagement.models.Course;
import java.util.List;
import cat.uvic.teknos.coursemanagement.models.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RestClientImplTest {
    @Test
    void getTest() {
        var restClient = new RestClientImpl("localhost", 8888);
        try {
            Course course = restClient.get("courses/1", CourseDto.class);

            assertNotNull(course);
        } catch (RequestException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getAllTest() {
        var restClient = new RestClientImpl("localhost", 8888);
        try {
            Course[] courses = restClient.getAll("courses", CourseDto[].class);

            assertNotNull(courses);
        } catch (RequestException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void postTest() {
        var restClient = new RestClientImpl("localhost", 8888);
        try {
            var course = new CourseDto();
            course.setName("Test");
            course.setYear(2024);

            restClient.post("courses", Mappers.get().writeValueAsString(course));

        } catch (RequestException | JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}