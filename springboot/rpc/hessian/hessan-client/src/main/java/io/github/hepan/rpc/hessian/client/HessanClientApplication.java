package io.github.hepan.rpc.hessian.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

@SpringBootApplication
public class HessanClientApplication {

    public static void main(String[] args) {
//        SpringApplication.run(HessanClientApplication.class, args);?
        ConfigurableApplicationContext context = SpringApplication.run(HessanClientApplication.class, args);
        System.out.println("========Client Side===============");
        HelloWebInterface helloWorld = context.getBean(HelloWebInterface.class);
        System.out.println(helloWorld.hello("Sajal"));


        System.out.println(helloWorld.getUser(1));


    }

    @Bean
    public HessianProxyFactoryBean hessianInvoker() {
        HessianProxyFactoryBean invoker = new HessianProxyFactoryBean();
        invoker.setServiceUrl("http://localhost:8080/hellohessian");
        invoker.setServiceInterface(HelloWebInterface.class);
        return invoker;
    }
}
