package io.github.hepan.springboot.thread.executor.demo.my.sender;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hp
 * @describe
 * @createTime 2019/9/8 10:41
 **/
@Slf4j
@Component
public class ConsumeMailQueue {

    ExecutorService executorService = null;
    @Autowired
    private MessageSenderService messageSenderService;

    @PostConstruct
    public void startThread() {
        int size = 10;

        ExecutorService e = Executors.newFixedThreadPool(size);// 两个大小的固定线程池
        for (int i = 0; i < size; i++) {
            e.submit(new PollMessage(messageSenderService));
        }
    }

    @PreDestroy
    public void stopThread() {
        log.info("destroy");
        executorService.shutdownNow();
    }

    class PollMessage implements Runnable {
        private MessageSenderService messageSenderService;

        public PollMessage(MessageSenderService messageSenderService) {
            this.messageSenderService = messageSenderService;
        }


        @Override
        public void run() {
            while (true) {
                try {
                    MessageBean messageBean = SenderQueue.getInstance().consume();
                    Thread.sleep(10000);
                    if (messageBean != null) {
                        log.info("剩余消息总数：{}", SenderQueue.getInstance().size());
                        messageSenderService.send(messageBean);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
