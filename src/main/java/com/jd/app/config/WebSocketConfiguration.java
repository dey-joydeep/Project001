package com.jd.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

import com.jd.app.websocket.TextMessageHandler;

@Configuration
@EnableWebSocket
@ComponentScan("com.jd.app.websocket")
public class WebSocketConfiguration implements WebSocketConfigurer {

	@Autowired
	protected TextMessageHandler textMessageHandler;
	@Autowired
	protected BinaryWebSocketHandler binaryMessageHandler;

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(textMessageHandler, "/socket/conn/tws");
		registry.addHandler(binaryMessageHandler, "/socket/conn/bws");
	}
	
	@Bean
	public ServletServerContainerFactoryBean createWebSocketContainer() {
		ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
		container.setMaxBinaryMessageBufferSize(26214400);
		return container;
	}
}
