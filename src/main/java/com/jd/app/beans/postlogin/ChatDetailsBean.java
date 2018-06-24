package com.jd.app.beans.postlogin;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.jd.app.beans.common.SharedBean;

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
