package com.jd.app.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

@Component
public class BinaryMessageHandler extends BinaryWebSocketHandler {

	@Override
	public void handleTransportError(WebSocketSession session,
			Throwable throwable) throws Exception {
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus status) throws Exception {
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session)
			throws Exception {
	}

	@Override
	protected void handleBinaryMessage(WebSocketSession session,
			BinaryMessage message) throws Exception {
	}
}
