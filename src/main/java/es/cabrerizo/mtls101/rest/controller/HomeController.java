package es.cabrerizo.mtls101.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home redirection to OpenAPI api documentation
 */
@Controller
public class HomeController implements es.cabrerizo.mtls101.rest.api.HomeApi {

    @Override
    public String home() {
        return "redirect:swagger-ui.html";
    }
}
