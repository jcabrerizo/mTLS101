package es.cabrerizo.mtls101.rest.api;

import es.cabrerizo.mtls101.rest.model.StringResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface HelloApi {

    String APPLICATION_JSON_UTF8_VALUE_MEDIA_TYPE = "application/json;charset=UTF-8";

    @GetMapping(
            path = "/hello",
            produces = APPLICATION_JSON_UTF8_VALUE_MEDIA_TYPE
    )
    @Operation(
            operationId = "hello",
            summary = "Returns 'Hello world'",
            description = "Simple endpoint for testing",
            tags = {"hello"}
    )
    default ResponseEntity<StringResponse> getHello(HttpServletRequest request) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
