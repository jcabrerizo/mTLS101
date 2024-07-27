package es.cabrerizo.mtls101.config;

import com.fasterxml.jackson.databind.Module;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

    private final BuildProperties buildProperties;

    public SpringDocConfiguration(BuildProperties buildProperties) {
        this.buildProperties = buildProperties;
    }

    @Bean(name = "appInfo")
    OpenAPI apiInfo() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("mTSL 101")
                                .description("mTLS configuration example for Spring boot 3")
                                .version(buildProperties.getVersion())
                );
    }

}
