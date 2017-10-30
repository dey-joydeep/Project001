package com.jd.app.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class TextMessageHandler extends TextWebSocketHandler {

	@Override
	public void handleTransportError(WebSocketSession session,
			Throwable throwable) throws Exception {
		throwable.printStackTrace();
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus status) throws Exception {
		System.out.println("Connection closed");
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session)
			throws Exception {
		System.out.println("Connection establised");
	}

	@Override
	protected void handleTextMessage(WebSocketSession session,
			TextMessage jsonTextMessage) throws Exception {
		String message = new String(jsonTextMessage.asBytes());
		System.out.println(message);
	}
}
