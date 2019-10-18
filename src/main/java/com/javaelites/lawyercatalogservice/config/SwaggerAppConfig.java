package com.javaelites.lawyercatalogservice.config;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import com.google.common.collect.Lists;

import io.swagger.annotations.Api;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan(basePackages = "com.javaelites.lawyercatalogservice")
public class SwaggerAppConfig {

	public static final String DEFAULT_URI_PATTERN = "/api/.*";
	
	@Bean
	public Docket api() { 
	    return new Docket(DocumentationType.SWAGGER_2)  
	      .select()                                  
	      .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))              
	      .paths(PathSelectors.any())                        
	      .build().pathMapping("/")
	      .directModelSubstitute(LocalDate.class,  String.class)
	      .genericModelSubstitutes(ResponseEntity.class)
	      .useDefaultResponseMessages(false)
	      .apiInfo(apiInfo())
	      .securitySchemes(Lists.newArrayList(apiKey()))
	      .securityContexts(Arrays.asList(securityContext()));
	}
	
	private ApiKey apiKey() {
	    return new ApiKey("api_key", "api_key", "query");
	}
	
	private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuthorization())
                .forPaths(PathSelectors.regex(DEFAULT_URI_PATTERN))
                .build();
    }

    List<SecurityReference> defaultAuthorization() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(new SecurityReference("api_key", authorizationScopes));
    }
	  
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Lawyer Catalog API Documentation")
				.description("Lawyer Catalog Rest API's")
				.version("1.0")
				.contact(new Contact("java.elite2020@gmail.com",  null, null))
//				.license("Apache 2.0")
//				.licenseUrl("http://www.apache.org/liceses/LICENSE-2.0.html")
				.build();
	}
	
}
