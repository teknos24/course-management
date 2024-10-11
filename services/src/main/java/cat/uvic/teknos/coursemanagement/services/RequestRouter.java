package cat.uvic.teknos.coursemanagement.services;

import rawhttp.core.RawHttpRequest;
import rawhttp.core.RawHttpResponse;

public interface RequestRouter {
    RawHttpResponse<?> execRequest(RawHttpRequest request);
}
