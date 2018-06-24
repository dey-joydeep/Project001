package com.jd.app.beans.common;

import lombok.Getter;
import lombok.Setter;

public class PasswordBean extends SharedBean {

	@Getter
	@Setter
	private String password;

	@Getter
	@Setter
	private String confirmPassword;

}
