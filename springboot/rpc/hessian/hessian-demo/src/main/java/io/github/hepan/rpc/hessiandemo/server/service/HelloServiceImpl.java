package io.github.hepan.rpc.hessiandemo.server.service;

import io.github.hepan.rpc.hessiandemo.server.model.UserBean;
import io.github.hepan.rpc.hessiandemo.server.model.UserTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hp
 * @describe
 * @createTime 2019/9/12 15:34
 **/
@Service
@Slf4j
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        log.info("----->" + name);
        return "hello : " + name;
    }

    @Override
    public UserBean getUser(int id) {

        List<String> names = new ArrayList<>();
        names.add("123");
        names.add("234");
        names.add("345");

        return UserBean.builder().id(123).name("zhangsan").nickName(names).type(UserTypeEnum.A).build();
    }
}
