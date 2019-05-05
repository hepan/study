package io.github.hepan.springboot.stomp.demo.config;

import io.github.hepan.springboot.stomp.demo.websocket.WebSocketHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @author hp
 * @Description: websocket配置
 * @date 2019-04-26 14:46
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").setAllowedOrigins("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 设置接收客户端消息 的 路径前缀（不设置可以）
        registry.setApplicationDestinationPrefixes("/app");
        // 设置接收客户端订阅 的 路径前缀（必须不设置，可以为空串）
        registry.enableSimpleBroker("/topic");
    }




    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        // 添加拦截器，处理客户端发来的请求
        registration.interceptors(new WebSocketHandlerInterceptor());
    }
}
