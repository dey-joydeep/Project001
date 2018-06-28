package com.jd.app.modules.login.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.jd.app.shared.constants.SharedBean;

@ToString
@JsonInclude(Include.NON_EMPTY)
public class LoginBean extends SharedBean {

	@Getter
	@Setter
	private String loginId;

	@Getter
	@Setter
	private String username;

	@Getter
	@Setter
	private String password;

	@Getter
	@Setter
	private boolean rememberMe;
}
