package io.github.hepan.nacos.discovery.consumer.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author hp
 * @describe
 * @createTime 2020/3/18 18:59
 **/
@SpringBootApplication
@EnableFeignClients
public class NacosDiscoveryConsumerExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosDiscoveryConsumerExampleApplication.class);
    }
}
