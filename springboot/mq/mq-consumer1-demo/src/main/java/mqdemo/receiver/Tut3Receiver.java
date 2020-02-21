package mqdemo.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author hp
 * @describe
 * @createTime 2020/2/21 10:52
 **/
@Component
public class Tut3Receiver {



    @RabbitListener(queues="fanout.C")
    public void receiveC(String in ) throws InterruptedException{
        System.out.println("consumer faanout C "+ in);
    }

}
