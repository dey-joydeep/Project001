package com.jd.app.shared.constants;

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
