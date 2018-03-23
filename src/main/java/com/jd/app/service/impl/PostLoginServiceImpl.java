package com.jd.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

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
			bean.setFirstname("User-" + (i + 1));
			bean.setLastname("");
			bean.setPublicUsername("user" + (i + 1));

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
			bean.setMessageId("" + (i + 1));
			bean.setContent("Content1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111-"
					+ (i + 1));
			if (i % 2 == 0) {
				bean.setSenderId("user1");
				bean.setSenderName("User-1");
			} else {
				bean.setReceiverId("user2");
				bean.setReceiverFirstname("User-2");
			}

			bean.setAvatar("resources/images/png/avatar_generic.png");
			messageList.add(bean);
		}
		return messageList;
	}
}
