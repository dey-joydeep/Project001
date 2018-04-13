package com.jd.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.jd.app.beans.common.CommonMenuBean;
import com.jd.app.beans.postlogin.FrameBean;
import com.jd.app.beans.postlogin.MenuBean;
import com.jd.app.beans.postlogin.MessageBean;
import com.jd.app.beans.postlogin.UserDetailsBean;
import com.jd.app.service.def.PostLoginService;

@Service
public class PostLoginServiceImpl implements PostLoginService {

	@Override
	public List<UserDetailsBean> loadUsers(String loginId) {
		List<UserDetailsBean> userList = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			UserDetailsBean bean = new UserDetailsBean();
			bean.setUsername(loginId);
			bean.setFirstname("User-" + (i + 1));
			bean.setLastname("");
			bean.setPublicUsername("user" + (i + 1));
			bean.setAvatar("resources/images/png/avatar_generic.png");
			userList.add(bean);
		}
		return userList;
	}

	@Override
	public List<MessageBean> loadOldMessages(String loginId, int currentSize,
			int nextSize) {
		List<MessageBean> messageList = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			MessageBean bean = new MessageBean();
			bean.setMessageId(Integer.toString(i + 1));
			if (i % 2 == 0) {
				bean.setSenderId("user1");
				bean.setSenderName("User-1");
				bean.setContent("Content1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111-"
						+ (i + 1));
			} else {
				bean.setReceiverId("user2");
				bean.setReceiverFirstname("User-2");
				bean.setContent("Content-" + (i + 1));
			}

			bean.setAvatar("resources/images/png/avatar_generic.png");
			messageList.add(bean);
		}
		return messageList;
	}

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
		bean.setIdentifier("inbox-icon");
		bean.setName("Inbox");
		bean.setSubMenuExists(false);
		bean.setIconName("move_to_inbox");
		bean.setTooltipPosition("bottom");
		bean.setMenuItemPosition("LEFT");
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
