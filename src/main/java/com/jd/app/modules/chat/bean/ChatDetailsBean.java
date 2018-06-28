package com.jd.app.modules.chat.bean;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.jd.app.shared.constants.SharedBean;

@ToString
public class ChatDetailsBean extends SharedBean {

	@Getter
	@Setter
	private String avatar;

	@Getter
	@Setter
	private String senderId;

	@Getter
	@Setter
	private String senderName;

	@Getter
	@Setter
	private List<MessageBean> messages;
}
