package io.github.hepan.rpc.hessian.client;


/**
 * @author hp
 * @describe
 * @createTime 2019/9/12 15:36
 **/
public interface HelloWebInterface {

    String hello(String name);

    UserBean getUser(int id);
}
