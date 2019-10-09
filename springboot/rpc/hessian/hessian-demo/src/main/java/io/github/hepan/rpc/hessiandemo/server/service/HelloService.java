package io.github.hepan.rpc.hessiandemo.server.service;

import io.github.hepan.rpc.hessiandemo.server.model.UserBean;

/**
 * @author hp
 * @describe
 * @createTime 2019/9/12 15:33
 **/

public interface HelloService {
    String hello(String name);

    UserBean getUser(int id);
}
