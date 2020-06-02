package com.btl.backend.btlbackend.config;

import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

//@Configuration
//@EnableSwagger2
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }



//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .useDefaultResponseMessages(false)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build()
////                .apiInfo(apiInfo())
//                .securitySchemes(Arrays.asList(apiKey()))
//                .securityContexts(Arrays.asList(securityContext()));
//    }

//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder().version(swaggerProperties.getVersion()).title(swaggerProperties.getTitle()).description(swaggerProperties.getDescription()).build();
//    }

//    private ApiKey apiKey() {
//        return new ApiKey("Authorization", "Authorization", "Authorization");
//    }
//
//    private SecurityContext securityContext() {
//        return SecurityContext.builder()
//                .securityReferences(defaultAuth())
//                .forPaths(Predicates.not(PathSelectors.ant("/auth/login")))
//                .build();
//    }
//
//    private List<SecurityReference> defaultAuth() {
//        return Arrays.asList(new SecurityReference("Authorization", new AuthorizationScope[] {new AuthorizationScope("global", "accessEverything")}));
//    }
}
