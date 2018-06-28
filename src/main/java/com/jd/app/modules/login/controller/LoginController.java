package com.jd.app.modules.login.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jd.app.modules.login.bean.LoginBean;
import com.jd.app.modules.login.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	LoginService loginService;

	@PostMapping(value = "/login", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public LoginBean login(@RequestBody LoginBean loginBean,
			HttpServletRequest request, HttpServletResponse response) {

		loginService.authorize(loginBean);

		if (loginBean.isSuccess()) {
			HttpSession session = request.getSession(true);
			session.setAttribute("loginId", loginBean.getLoginId());

			if (loginBean.isRememberMe()) {
				Cookie cookie = new Cookie("login-cookie",
						loginBean.getLoginId() + "-1");
				cookie.setMaxAge(365 * 60 * 60);
				response.addCookie(cookie);
			}
		}
		return loginBean;
	}

	@PostMapping(value = "/fp", produces = "application/json")
	@ResponseBody
	public LoginBean forgetPassword(@RequestBody LoginBean loginBean) {
		loginService.authorize(loginBean);
		return loginBean;
	}
}
