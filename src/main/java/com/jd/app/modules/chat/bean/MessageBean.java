package com.jd.app.modules.chat.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.jd.app.shared.constants.SharedBean;

@ToString
public class MessageBean extends SharedBean {

	@Getter
	@Setter
	private String messageId;

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
	private String content;

	@Getter
	@Setter
	private boolean hasAttachment;

	@Getter
	@Setter
	private Object attachment;

	@Getter
	@Setter
	private boolean sender;
}
