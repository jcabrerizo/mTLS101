package es.cabrerizo.mtls101.service;

import es.cabrerizo.mtls101.rest.model.StringResponse;
import org.springframework.stereotype.Service;

@Service
public class StringService {
    public StringResponse echo(String msg) {
        return new StringResponse(msg);
    }
}
