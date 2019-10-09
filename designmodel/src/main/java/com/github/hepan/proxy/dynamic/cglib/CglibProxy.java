package com.github.hepan.proxy.dynamic.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy<T> implements MethodInterceptor {

    private T target;

    public static void main(String[] args) {
        CglibProxy<GoodsService> proxy = new CglibProxy<>();
        GoodsService goodsService = proxy.getinstence(new GoodsService());
        goodsService.add();
        goodsService.delete("1234");

    }

    private T getinstence(T target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        //设置回调方法
        enhancer.setCallback(this);
        //创建代理对象
        return (T) enhancer.create();
    }

    @Override
    public T intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("CglibProxy.intercept begin");
        T t = (T) proxy.invokeSuper(obj, args);
        System.out.println("CglibProxy.intercept end");
        return t;
    }
}
