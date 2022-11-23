package com.home.nanda.config;

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

@Configuration
@EnableSwagger2
public class SwaggerConfig {

//	Swagger-UI 2.x 확인
//	http://localhost[:8080]/{your-app-root}/swagger-ui.html
//	Swagger-UI 3.x 확인
//	http://localhost[:8080]/{your-app-root}/swagger-ui/index.html

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("title")
                .description("<h3>최종 관통 프로젝트 Rest Api문서</h3>")
                .contact(new Contact("Master", "https://google.com", "me@gmail.com"))
                .license("MIT License")
                .version("v1.0")
                .build();
    }

    @Bean
    public Docket api1() {
        return new Docket(DocumentationType.SWAGGER_2) // Swagger 2.0 기반의 문서 작성
                .groupName("1")
                .apiInfo(apiInfo()) // 문서에 대한 정보를 설정한다.
                .select() // ApiSelectorBuilder를 반환하며 상세한 설정 처리
                .apis(RequestHandlerSelectors.basePackage("com.home.nanda.user.controller"))
                .paths(PathSelectors.any()) // controller에서 swagger를 지정할 대상 path 설정
                .build();  // Docket 객체 생성
    }

    @Bean
    public Docket api2() {
        return new Docket(DocumentationType.SWAGGER_2) // Swagger 2.0 기반의 문서 작성
                .groupName("2")
                .apiInfo(apiInfo()) // 문서에 대한 정보를 설정한다.
                .select() // ApiSelectorBuilder를 반환하며 상세한 설정 처리
                .apis(RequestHandlerSelectors.basePackage("com.home.nanda.house.controller"))
                .paths(PathSelectors.any()) // controller에서 swagger를 지정할 대상 path 설정
                .build();  // Docket 객체 생성
    }

    @Bean
    public Docket api3() {
        return new Docket(DocumentationType.SWAGGER_2) // Swagger 2.0 기반의 문서 작성
                .groupName("3")
                .apiInfo(apiInfo()) // 문서에 대한 정보를 설정한다.
                .select() // ApiSelectorBuilder를 반환하며 상세한 설정 처리
                .apis(RequestHandlerSelectors.basePackage("com.home.nanda.board.controller"))
                .paths(PathSelectors.any()) // controller에서 swagger를 지정할 대상 path 설정
                .build();  // Docket 객체 생성
    }

}

