package io.github.hepan.springcloud.zuulswagger.zszpp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class ZsZpp2Application {

    public static void main(String[] args) {
        SpringApplication.run(ZsZpp2Application.class, args);
    }


    @GetMapping("/hello-app-2/{str}")
    public String helloApp1(@PathVariable("str") String str) {
        String ret = "hello-app-2 -> " + str;
        System.out.println(ret);
        return ret;

    }

}
