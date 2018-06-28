package com.jd.app.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jd.app.shared.constants.WsConstants;

public class MessageHandler {

	public void sendUserStatusUpdate(
			Map<String, List<WebSocketSession>> sessionMap, String loginId,
			short status) throws JsonProcessingException, IOException {

		WsUserWrapper wrapper = new WsUserWrapper();
		wrapper.setIncomingType(WsConstants.INCOMING_TYPE_USER);
		wrapper.setLoginId(loginId);
		wrapper.setStatus(status);

		ObjectMapper mapper = Jackson2ObjectMapperBuilder.json().build();
		String userStatus = mapper.writeValueAsString(wrapper);

		List<String> friendList = new ArrayList<>();
		for (String friendId : friendList) {
			if (sessionMap.containsKey(friendId)) {
				List<WebSocketSession> sessionList = sessionMap.get(friendId);
				for (WebSocketSession session : sessionList) {
					session.sendMessage(new TextMessage(userStatus));
				}
			}
		}
	}
}
