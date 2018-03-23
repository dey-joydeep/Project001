package com.jd.app.websocket;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

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

@Component
public class MessageHandler extends AbstractWebSocketHandler {

	private static File uploadedFile = null;

	public void afterConnectionEstablished(WebSocketSession session)
			throws Exception {
		System.out.println("Connection establised");
	}

	protected void handlePongMessage(WebSocketSession session,
			PongMessage message) throws Exception {
	}

	public void handleTransportError(WebSocketSession session,
			Throwable exception) throws Exception {
		exception.printStackTrace();
	}

	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus status) throws Exception {
		System.out.println("Connection closed.\nReason:" + status);
	}

	protected void handleTextMessage(WebSocketSession session,
			TextMessage message) throws Exception {

		ObjectMapper mapper = Jackson2ObjectMapperBuilder.json().build();
		MessageHolder messageHolder = mapper.readValue(message.asBytes(),
				MessageHolder.class);

		System.out.println("Message: " + messageHolder.getMessage());
		String fileName = messageHolder.getFile();
		if (uploadedFile != null && fileName != null) {
			int lIdx = fileName.lastIndexOf('.');
			if (lIdx > -1) {
				String renameAs = uploadedFile.getAbsolutePath()
						+ fileName.substring(lIdx);
				uploadedFile.renameTo(new File(renameAs));
				uploadedFile = null;
			}
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
}
