package io.github.hepan.springboot.mq.demo.mqdemo.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * @author hp
 * @describe
 * @createTime 2020/2/21 10:52
 **/
@Component
public class Tut3Receiver {

    @RabbitListener(queues="fanout.A")
    public void receiveA(String in ) throws InterruptedException{
        System.out.println("consumer faanout A "+ in);
    }

    @RabbitListener(queues="fanout.B")
    public void receiveB(String in ) throws InterruptedException{
        System.out.println("consumer faanout B "+ in);
    }


}
