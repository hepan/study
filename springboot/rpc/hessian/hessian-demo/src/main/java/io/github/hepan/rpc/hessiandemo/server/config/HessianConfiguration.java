package io.github.hepan.rpc.hessiandemo.server.config;

import io.github.hepan.rpc.hessiandemo.server.HelloWebInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.remoting.support.RemoteExporter;


/**
 * @author hp
 */
@Configuration
@Slf4j
public class HessianConfiguration implements ApplicationContextAware {
    private static ApplicationContext applicationContext = null;

    @Bean(name = "/hellohessian")
    RemoteExporter sayHelloServiceHessian() {
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(applicationContext.getBean("helloHessan"));
        exporter.setServiceInterface(HelloWebInterface.class);


        return exporter;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("------SpringContextUtil setApplicationContext-------");
        HessianConfiguration.applicationContext = applicationContext;
    }
}