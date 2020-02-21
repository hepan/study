package io.github.hepan.springboot.mq.demo.mqdemo.service;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hp
 * @describe
 * @createTime 2020/2/21 10:47
 **/
@Service
public class Tut3Sender implements Tut3SenderInterface {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private FanoutExchange fanout;

    int dots = 0;
    int count = 0;

    @Override
    public void send() {
        String context = "hi, fanout msg ";
        System.out.println("Sender : " + context);
        template.convertAndSend("fanoutExchange","", context);
    }

}
