package com.jd.app.websocket;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.socket.WebSocketSession;

public class GlobalResource {
	public static volatile Map<String, List<WebSocketSession>> SESSION_HOLDER = new ConcurrentHashMap<>();
}
