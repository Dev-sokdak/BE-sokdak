package com.example.sokdak.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private String version = "V0.1";

    @Bean
    public Docket apiBoard(){
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)         //불필요한 응답코드와 설명 제거
                .groupName("board")                              //Bean이 여러개일 때 명시
                .select()                                        //ApiSelectorBuilder를 생성하여 apis()와 paths()를 사용
                /*.apis(RequestHandlerSelectors.any())*/         // api가 작성되있는 패키지를 지정
                .apis(RequestHandlerSelectors.                   // api가 작성되있는 패키지를 지정
                        basePackage("com.example.sokdak.board.controller"))
                .paths(PathSelectors.any())                      //URL 경로를 지정하여 해당 URL에 해당하는 요청만 Swagger API 문서로 만듬
                .build()
                .apiInfo(apiInfo());
    }
    @Bean
    public Docket apiComment(){
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)         //불필요한 응답코드와 설명 제거
                .groupName("comment")                            //Bean이 여러개일 때 명시
                .select()                                        //ApiSelectorBuilder를 생성하여 apis()와 paths()를 사용
                /*.apis(RequestHandlerSelectors.any())*/         // api가 작성되있는 패키지를 지정
                .apis(RequestHandlerSelectors.                   // api가 작성되있는 패키지를 지정
                        basePackage("com.example.sokdak.comment.controller"))
                .paths(PathSelectors.any())                      //URL 경로를 지정하여 해당 URL에 해당하는 요청만 Swagger API 문서로 만듬
                .build()
                .apiInfo(apiInfo());
    }
    @Bean
    public Docket apiMyPage(){
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)         //불필요한 응답코드와 설명 제거
                .groupName("myPage")                             //Bean이 여러개일 때 명시
                .select()                                        //ApiSelectorBuilder를 생성하여 apis()와 paths()를 사용
                /*.apis(RequestHandlerSelectors.any())*/         // api가 작성되있는 패키지를 지정
                .apis(RequestHandlerSelectors.                   // api가 작성되있는 패키지를 지정
                        basePackage("com.example.sokdak.mypage.controller"))
                .paths(PathSelectors.any())                      //URL 경로를 지정하여 해당 URL에 해당하는 요청만 Swagger API 문서로 만듬
                .build()
                .apiInfo(apiInfo());
    }
    @Bean
    public Docket apiUser(){
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)        //불필요한 응답코드와 설명 제거
                .groupName("user")                              //Bean이 여러개일 때 명시
                .select()                                       //ApiSelectorBuilder를 생성하여 apis()와 paths()를 사용
                /*.apis(RequestHandlerSelectors.any())*/        // api가 작성되있는 패키지를 지정
                .apis(RequestHandlerSelectors.                  // api가 작성되있는 패키지를 지정
                        basePackage("com.example.sokdak.user.controller"))
                .paths(PathSelectors.any())                     //URL 경로를 지정하여 해당 URL에 해당하는 요청만 Swagger API 문서로 만듬
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Devsokdak-Swagger")
                .description("개발자들의 커뮤니티 Dev-sokdak API")
                .version(version)
                .build();
    }
}