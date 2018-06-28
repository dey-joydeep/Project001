package com.jd.app.websocket;

import static com.jd.app.websocket.GlobalResource.SESSION_HOLDER;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jd.app.shared.constants.WsConstants;

@Component
public class WebSocketController extends AbstractWebSocketHandler {

	private static File uploadedFile = null;

	public void afterConnectionEstablished(WebSocketSession session)
			throws Exception {
		MessageHandler handler = new MessageHandler();
		List<WebSocketSession> sessionList;
		String loginId = session.getUri().getQuery().split("=")[1];

		if (SESSION_HOLDER.containsKey(loginId)) {
			sessionList = SESSION_HOLDER.get(loginId);
		} else {
			sessionList = new ArrayList<>();
		}

		sessionList.add(session);
		SESSION_HOLDER.put(loginId, sessionList);
		handler.sendUserStatusUpdate(SESSION_HOLDER, loginId,
				WsConstants.STATUS_ONLINE);
		System.out.println("Connection establised");
	}

	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus status) throws Exception {
		System.out.println("Connection closed.\nReason:" + status);
		boolean isSessionRemoved = false;
		MessageHandler handler = new MessageHandler();

		for (String loginId : SESSION_HOLDER.keySet()) {
			List<WebSocketSession> sessionList = SESSION_HOLDER.get(loginId);
			for (int i = 0; i < sessionList.size(); i++) {
				WebSocketSession targetSession = sessionList.get(i);
				if (targetSession.getId().equals(session.getId())
						&& !targetSession.isOpen()) {
					sessionList.remove(i);
					isSessionRemoved = true;
					break;
				}
			}

			if (isSessionRemoved && sessionList.isEmpty()) {
				handler.sendUserStatusUpdate(SESSION_HOLDER, loginId,
						WsConstants.STATUS_OFFLINE);
				break;
			}
		}
	}

	protected void handleTextMessage(WebSocketSession session,
			TextMessage message) throws Exception {

		try {
			ObjectMapper mapper = Jackson2ObjectMapperBuilder.json().build();
			WsMessageWrapper wsMessageWrapper = mapper.readValue(
					message.asBytes(), WsMessageWrapper.class);

			System.out.println("Message: " + wsMessageWrapper.getMessage());
			String fileName = wsMessageWrapper.getFile();
			if (uploadedFile != null && fileName != null) {
				int lIdx = fileName.lastIndexOf('.');
				if (lIdx > -1) {
					String renameAs = uploadedFile.getAbsolutePath()
							+ fileName.substring(lIdx);
					uploadedFile.renameTo(new File(renameAs));
					uploadedFile = null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void handleBinaryMessage(WebSocketSession session,
			BinaryMessage message) throws Exception {

		ByteBuffer byteBuffer = message.getPayload();
		File file = new File("C:/MyEclipse/ux/" + System.currentTimeMillis());

		try (FileOutputStream fos = new FileOutputStream(file, false);
				FileChannel wChannel = fos.getChannel()) {
			wChannel.write(byteBuffer.slice());
		}
		if (file.exists())
			uploadedFile = file;

		String ack = "1";
		WebSocketMessage<String> webSocketMessage = new TextMessage(ack);
		session.sendMessage(webSocketMessage);
	}

	protected void handlePongMessage(WebSocketSession session,
			PongMessage message) throws Exception {
	}

	public void handleTransportError(WebSocketSession session,
			Throwable exception) throws Exception {
		exception.printStackTrace();
	}

}
