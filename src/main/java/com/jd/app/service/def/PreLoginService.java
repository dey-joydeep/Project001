package com.jd.app.service.def;

import com.jd.app.beans.prelogin.LoginBean;
import com.jd.app.beans.prelogin.SignupBean;

public interface PreLoginService {

	void authorize(LoginBean loginBean);

	void validateSignup(SignupBean signupBean);

	void execSignup(SignupBean signupBean);

	void validateForgetPassword();

	void execForgetPassword();

}
