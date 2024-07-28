package es.cabrerizo.mtls101.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class SpringDocConfiguration {

    private final BuildProperties buildProperties;
    private final Environment environment;

    public SpringDocConfiguration(BuildProperties buildProperties, Environment environment) {
        this.buildProperties = buildProperties;
        this.environment = environment;
    }

    @Bean(name = "appInfo")
    OpenAPI apiInfo() {
        String profiles = String.join(",", environment.getActiveProfiles());
        return new OpenAPI()
                .info(
                        new Info()
                                .title("mTSL 101")
                                .description("A mTLS configuration example for Spring boot 3 <br/>" +
                                        "Active profiles: " + profiles)
                                .version(buildProperties.getVersion())
                );
    }

}
