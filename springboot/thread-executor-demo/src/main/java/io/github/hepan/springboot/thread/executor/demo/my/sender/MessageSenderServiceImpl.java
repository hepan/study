package io.github.hepan.springboot.thread.executor.demo.my.sender;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author hp
 * @describe
 * @createTime 2019/9/8 10:55
 **/
@Service
@Slf4j
public class MessageSenderServiceImpl implements MessageSenderService {
    @Override
    public void send(MessageBean message) {
        log.info("「sender」 send a message :{}", message);
    }
}
