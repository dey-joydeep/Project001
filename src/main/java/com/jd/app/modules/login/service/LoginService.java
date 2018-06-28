package com.jd.app.modules.login.service;

import com.jd.app.modules.login.bean.LoginBean;

public interface LoginService {

	void authorize(LoginBean loginBean);

	void execForgetPassword();
}
