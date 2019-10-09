package io.github.hepan.springboot.thread.executor.demo.my.sender;

/**
 * @author hp
 * @describe
 * @createTime 2019/9/8 10:54
 **/

public interface MessageSenderService {

    void send(MessageBean message);
}
