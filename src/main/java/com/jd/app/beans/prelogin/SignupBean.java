package com.jd.app.beans.prelogin;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.jd.app.beans.common.SharedBean;

@ToString
public class SignupBean extends SharedBean {

	@Getter
	@Setter
	private String email;

	@Getter
	@Setter
	private String password;

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
}
