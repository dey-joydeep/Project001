package com.jd.app.websocket;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class WsUserWrapper {

	@Getter
	@Setter
	private short incomingType;

	@Getter
	@Setter
	private String loginId;

	@Getter
	@Setter
	private short status;

}
