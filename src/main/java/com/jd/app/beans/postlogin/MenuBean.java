package com.jd.app.beans.postlogin;

import java.util.List;

import com.jd.app.beans.common.CommonMenuBean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class MenuBean extends CommonMenuBean {

	@Getter
	@Setter
	private boolean subMenuExists;

	@Getter
	@Setter
	private String iconName;

	@Getter
	@Setter
	private String tooltipPosition;

	@Getter
	@Setter
	private String menuItemPosition;

	@Getter
	@Setter
	private String clickActionType;

	@Getter
	@Setter
	private String modalTarget;

	@Getter
	@Setter
	private List<CommonMenuBean> subMenuList;
}
