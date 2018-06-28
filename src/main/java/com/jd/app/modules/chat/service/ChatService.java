package com.jd.app.modules.chat.service;

import java.util.List;

import com.jd.app.modules.chat.bean.ChatDetailsBean;
import com.jd.app.shared.bean.UserDetailsBean;

public interface ChatService {

	List<UserDetailsBean> loadUsers(String loginId);

	ChatDetailsBean loadMessages(String loginId, String friendId,
			int currentSize, int nextSize);
}
