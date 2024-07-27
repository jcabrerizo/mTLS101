package es.cabrerizo.mtls101.rest.api;

import org.springframework.web.bind.annotation.RequestMapping;

public interface HomeApi {

    @RequestMapping("/")
    String home();
}
