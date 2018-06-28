package com.jd.app.shared.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.jd.app.shared.bean.FrameBean;
import com.jd.app.shared.bean.MenuBean;
import com.jd.app.shared.constants.CommonMenuBean;

@Service
public class GeneralServiceImpl implements GeneralService {


	@Override
	public List<MenuBean> getMenus() {
		List<MenuBean> menuList = new ArrayList<>();

		MenuBean bean;
		CommonMenuBean subMenu;
		List<CommonMenuBean> subMenuList;
		Map<String, Object> attribMap;

		bean = new MenuBean();
		bean.setIdentifier("new-msg-icon");
		bean.setName("Create New Message");
		bean.setSubMenuExists(false);
		bean.setIconName("chat");
		bean.setTooltipPosition("bottom");
		bean.setMenuItemPosition("LEFT");
		bean.setClickActionType("MODAL");
		bean.setModalTarget("#new-msg-modal");
		bean.setLinkHref("#");
		menuList.add(bean);

		bean = new MenuBean();
		bean.setIdentifier("home-icon");
		bean.setName("Home");
		bean.setSubMenuExists(false);
		bean.setIconName("home");
		bean.setTooltipPosition("bottom");
		bean.setMenuItemPosition("LEFT");
		bean.setLinkHref("#");
		menuList.add(bean);

		bean = new MenuBean();
		bean.setIdentifier("logout-icon");
		bean.setName("Logout");
		bean.setSubMenuExists(false);
		bean.setIconName("power_settings_new");
		bean.setTooltipPosition("bottom");
		bean.setMenuItemPosition("RIGHT");
		bean.setLinkHref("#");
		menuList.add(bean);

		bean = new MenuBean();
		bean.setIdentifier("icon-settings");
		bean.setName("Settings");
		bean.setSubMenuExists(true);
		bean.setIconName("settings");
		bean.setTooltipPosition("top");
		bean.setMenuItemPosition("RIGHT");
		bean.setLinkHref("#settings");

		subMenuList = new ArrayList<>();
		subMenu = new CommonMenuBean();
		subMenu.setName("Account");
		subMenu.setParameterName("item");
		subMenu.setParameterValue("set-1");
		attribMap = new TreeMap<>();
		attribMap.put("data-param", "set-1");
		subMenu.setOtherAttributes(attribMap);
		subMenuList.add(subMenu);
		subMenu = new CommonMenuBean();
		subMenu.setName("General");
		subMenu.setParameterName("item");
		subMenu.setParameterValue("set-2");
		attribMap = new TreeMap<>();
		attribMap.put("data-param", "set-2");
		subMenu.setOtherAttributes(attribMap);
		subMenuList.add(subMenu);
		subMenu = new CommonMenuBean();
		subMenu.setName("Security");
		subMenu.setParameterName("item");
		subMenu.setParameterValue("set-3");
		attribMap = new TreeMap<>();
		attribMap.put("data-param", "set-3");
		subMenu.setOtherAttributes(attribMap);
		subMenuList.add(subMenu);
		subMenu = new CommonMenuBean();
		subMenu.setName("Privacy");
		subMenu.setParameterName("item");
		subMenu.setParameterValue("set-4");
		attribMap = new TreeMap<>();
		attribMap.put("data-param", "set-4");
		subMenu.setOtherAttributes(attribMap);
		subMenuList.add(subMenu);
		subMenu = new CommonMenuBean();
		subMenu.setName("Chats");
		subMenu.setParameterName("item");
		subMenu.setParameterValue("set-5");
		attribMap = new TreeMap<>();
		attribMap.put("data-param", "set-5");
		subMenu.setOtherAttributes(attribMap);
		subMenuList.add(subMenu);
		subMenu = new CommonMenuBean();
		subMenu.setName("Notification");
		subMenu.setParameterName("item");
		subMenu.setParameterValue("set-6");
		attribMap = new TreeMap<>();
		attribMap.put("data-param", "set-6");
		subMenu.setOtherAttributes(attribMap);
		subMenuList.add(subMenu);
		bean.setSubMenuList(subMenuList);
		menuList.add(bean);

		bean = new MenuBean();
		bean.setIdentifier("icon-profile");
		bean.setName("Profile");
		bean.setSubMenuExists(true);
		bean.setIconName("account_circle");
		bean.setTooltipPosition("top");
		bean.setMenuItemPosition("RIGHT");
		bean.setLinkHref("#profile");

		subMenuList = new ArrayList<>();
		subMenu = new CommonMenuBean();
		subMenu.setName("View");
		subMenuList.add(subMenu);
		subMenu = new CommonMenuBean();
		subMenu.setName("Edit");
		subMenuList.add(subMenu);
		bean.setSubMenuList(subMenuList);
		menuList.add(bean);

		return menuList;
	}

	@Override
	public List<FrameBean> getFrames() {
		List<FrameBean> frameList = new ArrayList<>();
		FrameBean frame;

		frame = new FrameBean();
		frame.setFrameId("chat-frame");
		frame.setFrameSource("chat");
		frameList.add(frame);

		frame = new FrameBean();
		frame.setFrameId("settings-frame");
		frame.setFrameSource("settings");
		frameList.add(frame);

		return frameList;
	}
}
