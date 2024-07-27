package es.cabrerizo.mtls101.rest.controller;

import es.cabrerizo.mtls101.rest.api.HelloApi;
import es.cabrerizo.mtls101.rest.model.StringResponse;
import es.cabrerizo.mtls101.service.StringService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${openapi.mergedSpec.base-path:}")
public class HelloController implements HelloApi {

    private final StringService service;

    public HelloController(StringService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<StringResponse> getHello(HttpServletRequest request) {
        return new ResponseEntity<>(service.echo("Hello world"), HttpStatus.OK);
    }
}
