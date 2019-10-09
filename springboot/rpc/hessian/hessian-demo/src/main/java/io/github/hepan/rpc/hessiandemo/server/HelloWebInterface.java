package io.github.hepan.rpc.hessiandemo.server;

import io.github.hepan.rpc.hessiandemo.server.model.UserBean;

/**
 * @author hp
 * @describe
 * @createTime 2019/9/12 15:36
 **/
public interface HelloWebInterface {

    String hello(String name);

    UserBean getUser(int id);
}
