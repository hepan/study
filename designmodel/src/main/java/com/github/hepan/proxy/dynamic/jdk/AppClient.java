package com.github.hepan.proxy.dynamic.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AppClient {
    public static void main(String[] args) {
        JDKProxy<UserManagerInterface> proxy = new JDKProxy<>();
        UserManagerInterface userManager = proxy.getProxy(new UserManagerImpl());
        System.out.println("被代理对象类型->" + userManager.getClass());
        userManager.add();
        userManager.delete("123");


        byte[] data = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{UserManagerInterface.class});
        try {
            FileOutputStream fos = new FileOutputStream("/Users/hp/IdeaProjects/study/designmodel/target/$Proxy0.class");
            fos.write(data);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
