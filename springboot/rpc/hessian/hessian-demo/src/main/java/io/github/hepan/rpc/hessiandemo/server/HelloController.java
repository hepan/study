package io.github.hepan.rpc.hessiandemo.server;

import io.github.hepan.rpc.hessiandemo.server.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hp
 * @describe
 * @createTime 2019/9/12 15:28
 **/
@RestController
@RequestMapping("/hessian")
public class HelloController {

    @Autowired
    HelloService helloService;

    @PostMapping("/hello")
    public String hello(String name) {
        return helloService.hello(name);
    }
}
