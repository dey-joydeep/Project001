package com.jd.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jd.app.beans.LoginBean;
import com.jd.app.service.def.LoginService;

@RestController
public class LoginController {

	@Autowired
	LoginService loginService;

	@PostMapping("/login")
	public LoginBean login(@RequestBody LoginBean loginBean) {
		loginService.authorize(loginBean);
		return loginBean;
	}
}
