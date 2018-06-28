package com.jd.app.modules.login.service;

import org.springframework.stereotype.Service;

import com.jd.app.modules.login.bean.LoginBean;

@Service
public class LoginServiceImpl implements LoginService {

	@Override
	public void authorize(LoginBean loginBean) {
		String message = "Access authorized!";
		if (loginBean.getLoginId().isEmpty()
				|| loginBean.getPassword().isEmpty())
			message = "Username/Password is required.";
		else if ("user1".equals(loginBean.getLoginId())
				&& "user1".equals(loginBean.getPassword()))
			loginBean.setSuccess(true);
		else
			message = "Username/Password is incorrect.";
		loginBean.setUsername(loginBean.getLoginId());
		loginBean.setPassword(null);
		loginBean.setMessage(message);
	}

	@Override
	public void execForgetPassword() {
		// TODO Auto-generated method stub

	}
}
