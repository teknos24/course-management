package cat.uvic.teknos.coursemanagement.services;

import cat.uvic.teknos.coursemanagement.models.Student;
import cat.uvic.teknos.coursemanagement.services.controllers.Controller;
import cat.uvic.teknos.coursemanagement.services.controllers.StudentController;
import cat.uvic.teknos.coursemanagement.services.exception.ResourceNotFoundException;
import cat.uvic.teknos.coursemanagement.services.exception.ServerErrorException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import rawhttp.core.RawHttp;
import rawhttp.core.RawHttpRequest;
import rawhttp.core.RawHttpResponse;

import java.util.Map;

public class RequestRouterImpl implements RequestRouter {
    private static RawHttp rawHttp = new RawHttp();
    private final Map<String, Controller> controllers;

    public RequestRouterImpl(Map<String, Controller> controllers) {
        this.controllers = controllers;
    }

    /**
     *
     *
     * @param request
     * @return the http response to send to the client
     */
    @Override
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

    private String manageStudents(RawHttpRequest request, String method, String[] pathParts, String responseJsonBody) {
        var controller = controllers.get(pathParts[1]);

        if (method.equals("POST")) {
            var studentJson = request.getBody().get().toString();
                controller.post(studentJson);

        } else if (method.equals("GET") && pathParts.length == 2) {
            responseJsonBody = controller.get();
        } else if (method.equals("DELETE")) {
            var studentId = Integer.parseInt(pathParts[2]);
            controller.delete(studentId);
        } else if (method.equals("PUT")) {
            var studentId = Integer.parseInt(pathParts[2]);
            var mapper = new ObjectMapper();

            var studentJson = request.getBody().get().toString();
            controller.put(studentId, studentJson);

        }
        return responseJsonBody;
    }
}
