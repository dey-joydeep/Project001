package com.jd.app.service.def;

import java.util.List;

import com.jd.app.beans.postlogin.ChatDetailsBean;
import com.jd.app.beans.postlogin.FrameBean;
import com.jd.app.beans.postlogin.MenuBean;
import com.jd.app.beans.postlogin.UserDetailsBean;

public interface PostLoginService {

	List<UserDetailsBean> loadUsers(String loginId);

	ChatDetailsBean loadMessages(String loginId, String friendId,
			int currentSize, int nextSize);

	List<MenuBean> getMenus();

	List<FrameBean> getFrames();
}
