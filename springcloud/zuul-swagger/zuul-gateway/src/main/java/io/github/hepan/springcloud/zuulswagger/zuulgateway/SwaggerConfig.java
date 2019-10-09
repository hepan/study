/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package io.github.hepan.springcloud.zuulswagger.zuulgateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author hepan
 * 2019/06/11 12:44
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    @Order(value = 1)
    public Docket groupRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(groupApiInfo());
    }

    private ApiInfo groupApiInfo() {
        return new ApiInfoBuilder()
                .title("zuul api collection")
                .description("这是个描述，api越看越happy！！！ 看这里，看这里，看这里，看这里。。。")
                .termsOfServiceUrl("http://www.group.com/")
                .version("1.0")
                .build();
    }
}
