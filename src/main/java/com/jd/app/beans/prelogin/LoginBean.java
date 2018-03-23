package com.jd.app.beans.prelogin;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.jd.app.beans.common.SharedBean;

@ToString
@JsonInclude(Include.NON_EMPTY)
public class LoginBean extends SharedBean {

	@Getter
	@Setter
	private String loginId;

	@Getter
	@Setter
	private String password;
}
