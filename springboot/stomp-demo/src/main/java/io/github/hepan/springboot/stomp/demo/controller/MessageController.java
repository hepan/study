package io.github.hepan.springboot.stomp.demo.controller;

import io.github.hepan.springboot.stomp.demo.websocket.StompUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * @author hp
 * @Description:TODO
 * @date 2019-04-26 17:19
 */

@Controller
public class MessageController {
    private static final Logger log = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private StompUserRepository stompUserRepository;


    @MessageMapping("/test/{id}")
    public void test(Message message,
                     MessageHeaders MessageHeaders,
                     @Header("destination") String destination,
                     @Headers Map<String, Object> headers,
                     @DestinationVariable String id,
                     @Payload String body) {
        log.info("[test] Message: {}", message);
        log.info("[test] MessageHeaders: {}", MessageHeaders);
        log.info("[test] Header: {}", destination);
        log.info("[test] Headers: {}", headers);
        log.info("[test] DestinationVariable: {}", id);
        log.info("[test] Payload: {}", body);

        System.out.println(id + "----------");
    }


    @MessageMapping("/bind/{resource}")
    public boolean bindResource(Message message,
                                @DestinationVariable String resource) {
        return stompUserRepository.addRepo(StompHeaderAccessor.wrap(message).getUser(), resource);
    }

    @MessageMapping("/release/{resource}")
    public void releaseResource(Message message, @DestinationVariable String resource) {
        stompUserRepository.releaseResource(StompHeaderAccessor.wrap(message).getUser(), resource);
    }
}
