package com.github.hepan.proxy.dynamic.cglib;

public class GoodsService {
    public void add() {
        System.out.println("调用 add 方法");
    }

    public void delete(String id) {
        System.out.println("调用 delete 方法 传入参数 id->" + id);
    }
}
