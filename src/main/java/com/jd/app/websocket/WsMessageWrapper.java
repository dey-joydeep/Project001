package com.jd.app.websocket;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class WsMessageWrapper {

	@Getter
	@Setter
	private String incomingType;

	@Getter
	@Setter
	private String messageId;

	@Getter
	@Setter
	private String senderId;

	@Getter
	@Setter
	private String recieverId;

	@Getter
	@Setter
	private String file;

	@Getter
	@Setter
	private String message;

	@Getter
	@Setter
	private String sentAt;

	@Getter
	@Setter
	private String deliveredAt;

	@Getter
	@Setter
	private String readAt;

	@Getter
	@Setter
	private String deliveryStatus;

}
