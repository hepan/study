package io.github.hepan.nacos.discovery.provider.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hp
 * @describe
 * @createTime 2020/3/18 18:49
 **/
@RestController
@RefreshScope
public class EchoController {

    @Value("${demo.username}")

    private String username;

    @GetMapping("/echo/{string}")
    public String echo(@PathVariable String string) {
        return "hello 1->" + string;
    }
    @GetMapping("/hello")
    public String hello(){
        return "hello 1->" + username;
    }
}
