package com.mao.swagger1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig1 {

    @Bean
    public Docket userDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("商品接口文档")
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.mao.swagger1.goods.controller"))
                .build();
    }

    @Bean
    public Docket deviceDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("用户接口文档")
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.mao.swagger1.user.controller"))
                .build()
                .apiInfo(apiInfo())
                .tags(
                        new Tag("UserController","用户接口")
                );
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("My API 2").version("1.0.0").build();
    }

}
