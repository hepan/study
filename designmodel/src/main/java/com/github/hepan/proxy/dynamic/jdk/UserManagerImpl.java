package com.github.hepan.proxy.dynamic.jdk;

public class UserManagerImpl implements UserManagerInterface {
    @Override
    public void add() {
        System.out.println("调用 add 方法");
    }

    @Override
    public void delete(String id) {
        System.out.println("调用 delete 方法 入参 id-> "+id);
    }
}
