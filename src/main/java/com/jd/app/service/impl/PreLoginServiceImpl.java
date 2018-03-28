package com.jd.app.service.impl;

import org.springframework.stereotype.Service;

import com.jd.app.beans.prelogin.LoginBean;
import com.jd.app.service.def.PreLoginService;

@Service
public class PreLoginServiceImpl implements PreLoginService {

	@Override
	public void authorize(LoginBean loginBean) {
		String message = "Access authorized!";
		if (loginBean.getLoginId().isEmpty()
				|| loginBean.getPassword().isEmpty())
			message = "Username/Password is not entered.";
		else if ("123".equals(loginBean.getLoginId())
				&& "123".equals(loginBean.getPassword()))
			loginBean.setSuccess(true);
		else
			message = "Access not authorized!";
		loginBean.setPassword(null);
		loginBean.setMessage(message);
	}

	@Override
	public void callSignup() {
		// TODO Auto-generated method stub

	}

	@Override
	public void execSignup() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initForgetPassword() {
		// TODO Auto-generated method stub

	}

	@Override
	public void execForgetPassword() {
		// TODO Auto-generated method stub

	}
}
