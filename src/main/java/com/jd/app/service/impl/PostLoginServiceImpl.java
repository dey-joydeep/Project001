package com.jd.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.jd.app.beans.common.CommonMenuBean;
import com.jd.app.beans.postlogin.ChatDetailsBean;
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
		for (int i = 1; i < 50; i++) {
			UserDetailsBean bean = new UserDetailsBean();
			bean.setUsername(loginId);
			bean.setFirstname("User-" + (i + 1));
			bean.setLastname("");
			bean.setPublicUsername("user" + (i + 1));
			bean.setAvatar("resources/images/png/avatar_generic.png");
			if (i % 2 == 0) {
				bean.setLastMessage("Content123456789Content123456789Content123456789Content123456789Content123456789Content123456789Content123456789Content123456789Content123456789");
				bean.setStatus(0);
			} else {
				bean.setStatus(1);
				bean.setLastMessage("Content123456789");
			}

			// -1: failed, 0:sent, 1: delivered, 2: read
			if (i % 4 == 0) {
				bean.setLastMessageStatus((short) 0);
			} else if (i % 3 == 0) {
				bean.setLastMessageStatus((short) 1);
			} else if (i % 2 == 0) {
				bean.setLastMessageStatus((short) 2);
			} else {
				bean.setLastMessageStatus((short) -1);
			}
			bean.setLastMessageTime("2011/11/12 20:55");
			userList.add(bean);
		}
		return userList;
	}

	@Override
	public ChatDetailsBean loadMessages(String loginId, String friendId,
			int currentSize, int nextSize) {
		ChatDetailsBean chatDetails = new ChatDetailsBean();

		// TODO: Get sender's summary
		chatDetails.setAvatar("resources/images/png/avatar_generic.png");
		chatDetails.setSenderId("user2");
		chatDetails.setSenderName("User-2");

		// TODO: Get messages from current size to next size
		List<MessageBean> messageList = new ArrayList<>();
		if (friendId.equals("user2")) // temporary code
			for (int i = currentSize; i < nextSize; i++) {
				MessageBean bean = new MessageBean();
				bean.setMessageId(Integer.toString(i + 1));
				if (i % 2 == 0) {
					bean.setContent("Content1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111-"
							+ (i + 1));
					bean.setSender(true);
				} else {
					bean.setContent("Content-" + (i + 1));
				}

				messageList.add(bean);

				bean.setSentAt("2018/03/23 11:15:39");
			}

		chatDetails.setMessages(messageList);
		return chatDetails;
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
