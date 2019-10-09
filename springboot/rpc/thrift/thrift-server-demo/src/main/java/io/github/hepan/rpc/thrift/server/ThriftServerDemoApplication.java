package io.github.hepan.rpc.thrift.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author hp
 */
@SpringBootApplication
@Slf4j
public class ThriftServerDemoApplication {
    private static ThriftServer thriftServer;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ThriftServerDemoApplication.class, args);

        try {
            thriftServer = context.getBean(ThriftServer.class);
            thriftServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
