package com.jd.app.service.def;

import java.util.List;

import com.jd.app.beans.postlogin.FrameBean;
import com.jd.app.beans.postlogin.MenuBean;
import com.jd.app.beans.postlogin.MessageBean;
import com.jd.app.beans.postlogin.UserDetailsBean;

public interface PostLoginService {

	List<UserDetailsBean> loadUsers(String loginId);

	List<MessageBean> loadOldMessages(String loginId, int currentSize,
			int nextSize);

	List<MenuBean> getMenus();

	List<FrameBean> getFrames();

}
