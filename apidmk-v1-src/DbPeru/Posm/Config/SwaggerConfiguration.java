package DbPeru.Posm.Config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableWebMvc
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
   Contact contact = new Contact("DESARROLLADORES TI", "http://www.DBPERU.com", "desarrollo@dbperu.com");
   ApiInfo apiInfo = new ApiInfo("API CheckOut DMK-Togo ", "Página de Controladores de API DMK - TOGO", "1.1.2", "http://www.appsdeveloperblof.com/service.html", "contact", "Apache/widfly", "http://www.apache.org/licenses/LICENSE-2.0");

   @Bean
   public Docket productApi() {
      return (new Docket(DocumentationType.SWAGGER_2)).apiInfo(this.apiInfo).select().apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).paths(PathSelectors.any()).build();
   }
}
