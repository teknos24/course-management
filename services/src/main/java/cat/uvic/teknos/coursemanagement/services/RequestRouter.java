package cat.uvic.teknos.coursemanagement.services;

import cat.uvic.teknos.coursemanagement.services.exception.ResourceNotFoundException;
import cat.uvic.teknos.coursemanagement.services.exception.ServerErrorException;
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

        RawHttpResponse response = null;
        try {
            // TODO: Router logic
            var json =  ""; //studentController.get();
            response = rawHttp.parseResponse("HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/json\r\n" +
                    "Content-Length: " + json.length() + "\r\n" +
                    "\r\n" +
                    json);
        } catch (ResourceNotFoundException exception) {
            response = null;
        } catch (ServerErrorException exception) {
            response = null;
        }

        return null;
    }
}
