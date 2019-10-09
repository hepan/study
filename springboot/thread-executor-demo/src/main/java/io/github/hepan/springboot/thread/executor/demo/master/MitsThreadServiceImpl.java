package io.github.hepan.springboot.thread.executor.demo.master;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author hp
 * @describe
 * @createTime 2019/9/8 09:37
 **/
@Slf4j
@Service
public class MitsThreadServiceImpl implements MitsThreadService {
    @Override
    public void call() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        scheduledExecutorService.schedule(
                new Sender()
                , 1000, TimeUnit.MILLISECONDS);
        scheduledExecutorService.shutdown();
    }

    class Sender implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("sender 开始执行");
        }
    }
}
