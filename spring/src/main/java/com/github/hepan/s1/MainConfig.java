package com.github.hepan.s1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig {

    @Bean
    public Person person() {
        System.out.println("person 创建");
        return new Person("zhangsan", 11);
    }
}
