package io.github.hepan.springboot.thread.executor.demo.my.sender;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author hp
 * @describe
 * @createTime 2019/9/8 10:32
 **/
public class SenderQueue {
    //队列大小
    static final int QUEUE_MAX_SIZE = 50;

    static BlockingQueue<MessageBean> blockingQueue = new LinkedBlockingQueue<MessageBean>(QUEUE_MAX_SIZE);

    /**
     * 单例
     */
    private SenderQueue() {
    }

    public static SenderQueue getInstance() {
        return SingletonHolder.queue;
    }

    public void produce(MessageBean message) throws InterruptedException {
        blockingQueue.put(message);
    }

    public MessageBean consume() throws InterruptedException {
        return blockingQueue.take();
    }

    public int size() {
        return blockingQueue.size();
    }

    private static class SingletonHolder {
        private static SenderQueue queue = new SenderQueue();
    }
}
