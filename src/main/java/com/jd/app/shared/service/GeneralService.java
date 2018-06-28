package com.jd.app.shared.service;

import java.util.List;

import com.jd.app.shared.bean.FrameBean;
import com.jd.app.shared.bean.MenuBean;

public interface GeneralService {

	List<MenuBean> getMenus();

	List<FrameBean> getFrames();
}
