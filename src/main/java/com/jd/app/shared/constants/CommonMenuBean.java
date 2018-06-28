package com.jd.app.shared.constants;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class CommonMenuBean {

	@Getter
	@Setter
	private String identifier;

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private String parameterName;

	@Getter
	@Setter
	private String parameterValue;

	@Getter
	@Setter
	private String linkHref;

	@Getter
	@Setter
	private Map<String, Object> otherAttributes;
}
