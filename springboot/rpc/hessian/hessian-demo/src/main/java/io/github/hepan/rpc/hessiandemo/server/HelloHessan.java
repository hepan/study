package io.github.hepan.rpc.hessiandemo.server;

import io.github.hepan.rpc.hessiandemo.server.model.UserBean;
import io.github.hepan.rpc.hessiandemo.server.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author hp
 * @describe
 * @createTime 2019/9/12 15:42
 **/
@Component
public class HelloHessan implements HelloWebInterface {

    @Autowired
    HelloService helloService;

    @Override
    public String hello(String name) {
        return helloService.hello(name);
    }

    @Override
    public UserBean getUser(int id) {
        return helloService.getUser(id);
    }
}
