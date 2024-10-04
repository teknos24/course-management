package cat.uvic.teknos.coursemanagement.services;

import cat.uvic.teknos.coursemanagement.models.Student;
import cat.uvic.teknos.coursemanagement.services.controllers.StudentController;
import cat.uvic.teknos.coursemanagement.services.exception.ResourceNotFoundException;
import cat.uvic.teknos.coursemanagement.services.exception.ServerErrorException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import rawhttp.core.RawHttp;
import rawhttp.core.RawHttpOptions;
import rawhttp.core.RawHttpRequest;
import rawhttp.core.RawHttpResponse;

public class RequestRouter {
    private static RawHttp rawHttp = new RawHttp();

    /**
     *
     *
     * @param request
     * @return the http response to send to the client
     */
    public RawHttpResponse<?> execRequest(RawHttpRequest request) {
        var path = request.getUri().getPath();
        var method = request.getMethod();
        var pathParts = path.split("/");
        var controllerName = pathParts[1];
        var responseJsonBody = "";
        
        switch (controllerName) {
            case "courses":
                responseJsonBody = manageStudents(request, method, pathParts, responseJsonBody);
                break;

        }

        RawHttpResponse response = null;
        try {
            // TODO: Router logic


            
            response = rawHttp.parseResponse("HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/json\r\n" +
                    "Content-Length: " + responseJsonBody.length() + "\r\n" +
                    "\r\n" +
                    responseJsonBody);
        } catch (ResourceNotFoundException exception) {
            response = null;
        } catch (ServerErrorException exception) {
            response = null;
        }

        return null;
    }

    private static String manageStudents(RawHttpRequest request, String method, String[] pathParts, String responseJsonBody) {
        var controller = new StudentController();

        if (method == "POST") {
            var studentJson = request.getBody().get().toString();
            var mapper = new ObjectMapper();
            try {
                var student = mapper.readValue(studentJson, Student.class);
                controller.post(student);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } else if (method == "GET" && pathParts.length == 2) {
            responseJsonBody = controller.get();

        } else if (method == "DELETE") {
            var studentId = Integer.parseInt(pathParts[2]);
            controller.delete(studentId);
        } else if (method == "PUT") {
            var studentId = Integer.parseInt(pathParts[2]);
            var mapper = new ObjectMapper();
            try {
                var studentJson = request.getBody().get().toString();
                var student = mapper.readValue(studentJson, Student.class);
                controller.put(studentId, student);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        return responseJsonBody;
    }
}
