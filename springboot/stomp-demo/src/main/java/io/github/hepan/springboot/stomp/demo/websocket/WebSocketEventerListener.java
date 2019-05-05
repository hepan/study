package io.github.hepan.springboot.stomp.demo.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

/**
 * @author hp
 * @Description:TODO
 * @date 2019-04-26 14:59
 */
@Component
public class WebSocketEventerListener {
    private static final Logger log = LoggerFactory.getLogger(WebSocketEventerListener.class);
    @Autowired
    private StompUserRepository userRepository;

    @EventListener
    public void handleConnectListener(SessionConnectedEvent event){
        log.info("[ws-连接]  {}",event.getMessage());
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
        userRepository.addUser(accessor.getUser());
    }

    @EventListener
    public void handleDisconnectListener(SessionDisconnectEvent event) {
        log.info("[ws-断开]  {}",event.getMessage());
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
        userRepository.releaseUser(accessor.getUser());

    }
}
