package es.cabrerizo.mtls101.rest.controller;

import es.cabrerizo.mtls101.rest.api.HelloApi;
import es.cabrerizo.mtls101.rest.model.StringResponse;
import es.cabrerizo.mtls101.rest.model.StringResponseHelper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${openapi.mergedSpec.base-path:}")
public class HelloController implements HelloApi {

    private final StringResponseHelper responseHelper;
    private final String helloStr;

    public HelloController(StringResponseHelper responseHelper, @Value("${app.helloStr}") String helloStr) {
        this.responseHelper = responseHelper;
        this.helloStr = helloStr;
    }

    @Override
    public ResponseEntity<StringResponse> getHello(HttpServletRequest request) {
        return new ResponseEntity<>(responseHelper.create(helloStr), HttpStatus.OK);
    }
}
