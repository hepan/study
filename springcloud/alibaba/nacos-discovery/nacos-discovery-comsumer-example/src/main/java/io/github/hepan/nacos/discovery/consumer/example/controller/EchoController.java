package io.github.hepan.nacos.discovery.consumer.example.controller;

import io.github.hepan.nacos.discovery.consumer.example.fegin.ProviderInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hp
 * @describe
 * @createTime 2020/3/18 19:06
 **/
@RestController
public class EchoController {

    @Autowired
    private ProviderInterface providerInterface;

    @GetMapping("/echo/{string}")
    public String echo(@PathVariable String string) {
        return providerInterface.echo(string);
    }
}
