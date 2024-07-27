package es.cabrerizo.mtls101.rest.model;

import org.springframework.stereotype.Service;

@Service
public class StringResponseHelper {
    public StringResponse create(String msg) {
        return new StringResponse(msg);
    }
}
