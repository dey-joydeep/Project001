package com.jd.app.modules.signup.bean;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.jd.app.shared.constants.PasswordBean;

@ToString
public class SignupBean extends PasswordBean {

	@Getter
	@Setter
	private short loginMode;

	@Getter
	@Setter
	private String email;

	@Getter
	@Setter
	private String phoneNo;

	@Getter
	@Setter
	private String firstname;

	@Getter
	@Setter
	private String lastname;

	@Getter
	@Setter
	private String birthdate;

	@Getter
	@Setter
	private String sex;

	@Getter
	@Setter
	private Map<String, String> errMap;

	@Getter
	@Setter
	private short deviceType;

	@Getter
	@Setter
	private short pageVal;
}
