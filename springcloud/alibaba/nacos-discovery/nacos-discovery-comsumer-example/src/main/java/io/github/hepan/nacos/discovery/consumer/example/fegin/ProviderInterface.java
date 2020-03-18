package io.github.hepan.nacos.discovery.consumer.example.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author hp
 * @describe
 * @createTime 2020/3/18 19:04
 **/
@FeignClient("nacos-discovery-provider-example")
public interface ProviderInterface {
    @GetMapping("/echo/{string}")
     String echo(@PathVariable("string") String string) ;
}
