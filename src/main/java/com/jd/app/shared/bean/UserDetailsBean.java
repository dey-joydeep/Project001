package com.jd.app.shared.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.jd.app.shared.constants.SharedBean;

@ToString
public class UserDetailsBean extends SharedBean {

	@Getter
	@Setter
	private String username;

	@Getter
	@Setter
	private String firstname;

	@Getter
	@Setter
	private String lastname;

	@Getter
	@Setter
	private String publicUsername;

	@Getter
	@Setter
	private String avatar;

	@Getter
	@Setter
	private String lastMessage;

	@Getter
	@Setter
	private String lastMessageTime;

	@Getter
	@Setter
	private short lastMessageStatus;
}
