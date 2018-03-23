package com.jd.app.service.def;

import com.jd.app.beans.prelogin.LoginBean;

public interface PreLoginService {

	void authorize(LoginBean loginBean);

	void callSignup();

	void execSignup();

	void initForgetPassword();

	void execForgetPassword();

}
