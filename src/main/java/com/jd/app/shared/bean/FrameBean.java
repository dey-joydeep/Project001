package com.jd.app.shared.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class FrameBean {

	@Getter
	@Setter
	private String frameId;

	@Getter
	@Setter
	private String frameSource;
}
