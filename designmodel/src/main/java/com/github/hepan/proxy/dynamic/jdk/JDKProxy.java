package com.github.hepan.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy<T> implements InvocationHandler {

    private T target;


    public T getProxy(T target) {

        this.target = target;
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before invoke --------");
        Object o = method.invoke(target, args);
        System.out.println("after invoke --------");

        return o;
    }


}
