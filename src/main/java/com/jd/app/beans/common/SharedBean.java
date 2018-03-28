package com.jd.app.beans.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class SharedBean {

	@Getter
	@Setter
	private boolean success;

	@Getter
	@Setter
	private int status;

	@Getter
	@Setter
	private String message;
}
