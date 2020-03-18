package io.github.hepan.nacos.discovery.provider.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hp
 * @describe
 * @createTime 2020/3/18 18:49
 **/
@RestController
public class EchoController {
    @GetMapping("/echo/{string}")
    public String echo(@PathVariable String string) {
        return "hello 1->" + string;
    }
}
