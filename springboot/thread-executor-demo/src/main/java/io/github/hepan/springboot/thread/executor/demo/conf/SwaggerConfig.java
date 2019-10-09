package io.github.hepan.springboot.thread.executor.demo.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author hp
 * create at 2018/10/25 6:42 PM
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Autowired
    private Environment env;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("thread test")
                .description("xxxx")
                .version("0.0.1")
                .build();
    }

    @Bean
    UiConfiguration uiConfig() {
        return new UiConfiguration(true, false, -1, -1,
                ModelRendering.MODEL, true, DocExpansion.LIST, null, null,
                OperationsSorter.ALPHA, true, TagsSorter.ALPHA, null);
    }

}
