package com.github.hepan.s1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class S1Run {
    public static void main(String[] args) {
        ApplicationContext ac=new AnnotationConfigApplicationContext(MainConfig.class);
        Person p=  ac.getBean(Person.class);
        System.out.println(p);

        String[] name=ac.getBeanNamesForType(Person.class);
        for (String s : name) {
            System.out.println(s);
        }

    }



}
