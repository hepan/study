package io.github.hepan.springboot.thread.executor.demo.my;

import io.github.hepan.springboot.thread.executor.demo.my.sender.MessageBean;
import io.github.hepan.springboot.thread.executor.demo.my.sender.SenderQueue;
import org.springframework.stereotype.Service;

/**
 * @author hp
 * @describe
 * @createTime 2019/9/8 10:23
 **/

@Service
public class MyThreadServiceImpl implements MyThreadService {


    @Override
    public void call() throws InterruptedException {
        SenderQueue.getInstance().produce(new MessageBean("123", "hello"));
    }


}

