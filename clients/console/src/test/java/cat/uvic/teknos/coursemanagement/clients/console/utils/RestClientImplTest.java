package cat.uvic.teknos.coursemanagement.clients.console.utils;

import cat.uvic.teknos.coursemanagement.clients.console.dto.CourseDto;
import cat.uvic.teknos.coursemanagement.clients.console.exceptions.RequestException;
import cat.uvic.teknos.coursemanagement.cryptoutils.CryptoUtils;
import cat.uvic.teknos.coursemanagement.models.Course;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.verify.VerificationTimes.once;

class RestClientImplTest {
    private ClientAndServer mockServer;

    @BeforeEach
    public void setUp() {
        mockServer = startClientAndServer(8888);
    }

    @AfterEach
    public void tearDown() {
        mockServer.stop();
    }

    @Test
    void getTest() throws JsonProcessingException {
        var secretKey = CryptoUtils.createSecretKey();
        var course = new CourseDto();
        course.setId(1);
        course.setName("test");
        course.setYear(2024);

        var body = Mappers.get().writeValueAsString(course);
        var encryptedBody = CryptoUtils.encrypt(body, secretKey);

        var path = "/courses/1";
        mockServer
                .when(HttpRequest.request().withPath(path).withMethod("GET"))
                .respond(HttpResponse.response().withBody(encryptedBody));

        var restClient = new RestClientImpl("localhost", 8888);
        try {
            var courseReturned = restClient.get(
                    "courses/1",
                    CourseDto.class,
                    (b) -> {
                        return CryptoUtils.decrypt(b, secretKey);
                    },
                    new RestClient.HeaderEntry("Test", "test"));
            assertNotNull(courseReturned);

        } catch (RequestException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getAllTest() {
        var restClient = new RestClientImpl("localhost", 8888);
        try {
            Course[] courses = restClient.getAll("courses", CourseDto[].class, null);

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

            restClient.post("courses", Mappers.get().writeValueAsString(course), null);

        } catch (RequestException | JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}