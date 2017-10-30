package com.jd.app.service.impl;

import org.springframework.stereotype.Service;

import com.jd.app.beans.LoginBean;
import com.jd.app.service.def.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Override
	public void authorize(LoginBean loginBean) {
		String message = "Cannot authorize the credentials.";
		loginBean.setStatus(false);
		loginBean.setMessage(message);
	}
}
