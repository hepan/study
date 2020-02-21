package io.github.hepan.springboot.mq.demo.mqdemo.web;

import io.github.hepan.springboot.mq.demo.mqdemo.service.Tut3SenderInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hp
 * @describe
 * @createTime 2020/2/21 10:30
 **/
@RestController
public class HelloController {

    @Autowired
    Tut3SenderInterface tut3SenderInterface;

    @GetMapping("/hello")
    public String hello (){
        tut3SenderInterface.send();
        return "Hello MQ";
    }
}
