package es.cabrerizo.mtls101.rest.controller;

import es.cabrerizo.mtls101.rest.api.HelloApi;
import es.cabrerizo.mtls101.rest.model.StringResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${openapi.mergedSpec.base-path:}")
public class HelloController implements HelloApi {

    private final StringResponseHelper responseHelper;

    public HelloController(StringResponseHelper responseHelper) {
        this.responseHelper = responseHelper;
    }

    @Override
    public ResponseEntity<StringResponse> getHello(HttpServletRequest request) {
        return new ResponseEntity<>(responseHelper.create("Hello world"), HttpStatus.OK);
    }
}
