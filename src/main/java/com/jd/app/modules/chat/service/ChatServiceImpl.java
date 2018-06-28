package com.jd.app.modules.chat.service;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.log4j.Log4j2;

import org.springframework.stereotype.Service;

import com.jd.app.modules.chat.bean.ChatDetailsBean;
import com.jd.app.modules.chat.bean.MessageBean;
import com.jd.app.shared.bean.UserDetailsBean;

@Service
@Log4j2
public class ChatServiceImpl implements ChatService {

	@Override
	public List<UserDetailsBean> loadUsers(String loginId) {
		log.info("Loading friend list for user ID: " + loginId);

		List<UserDetailsBean> userList = new ArrayList<>();
		for (int i = 1; i < 50; i++) {
			UserDetailsBean bean = new UserDetailsBean();
			bean.setUsername(loginId);
			bean.setFirstname("UserEntity-" + (i + 1));
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
		chatDetails.setSenderName("UserEntity-2");

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

}
