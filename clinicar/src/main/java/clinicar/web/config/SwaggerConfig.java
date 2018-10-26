package clinicar.web.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Petz
 * @since 08/06/18
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_12)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(paths())
                .build()
                .enableUrlTemplating(false);
    }

    private ApiInfo apiInfo(){

        Contact contact = new Contact(/*Nome do contato*/"Gabriel Petz", /* URL para o algum local desejado*/"", /*Email do contato*/"gabrielcspt1@gmail.com");

        ApiInfo apiInfoBuilder = new ApiInfoBuilder()
                .title("Clinicar Documentation")
                .description("All Functions Documentation")
                .version("1.0")
                .contact(contact)
                .license("Home Page")
                .licenseUrl("http://lcoalhost:8080")
                .termsOfServiceUrl(null)
                .extensions(null)
                .build();

        return apiInfoBuilder;
    }

    private Predicate<String> paths() {
        return Predicates.and(
                PathSelectors.regex("/.*"),
                Predicates.not(PathSelectors.regex("/home.*")),
                Predicates.not(PathSelectors.regex("/")),
                Predicates.not(PathSelectors.regex("/login.*")),
                Predicates.not(PathSelectors.regex("/swagger.*")));
    }
}
