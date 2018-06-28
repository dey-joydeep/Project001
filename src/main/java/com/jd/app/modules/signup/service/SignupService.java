package com.jd.app.modules.signup.service;

import com.jd.app.modules.signup.bean.SignupBean;

public interface SignupService {

	void validateSignup(SignupBean signupBean);

	long execSignup(SignupBean signupBean);

	void validateForgetPassword();

}
