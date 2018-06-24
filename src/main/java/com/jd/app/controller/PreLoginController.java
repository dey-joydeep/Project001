package com.jd.app.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jd.app.beans.prelogin.LoginBean;
import com.jd.app.beans.prelogin.SignupBean;
import com.jd.app.service.def.PreLoginService;

@RestController
public class PreLoginController {

	@Autowired
	PreLoginService preLoginService;

	@PostMapping(value = "/login", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public LoginBean login(@RequestBody LoginBean loginBean,
			HttpServletRequest request, HttpServletResponse response) {

		preLoginService.authorize(loginBean);

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

	@PostMapping(value = "/signup", produces = "application/json")
	@ResponseBody
	public SignupBean signup(@RequestBody SignupBean signupBean,
			HttpServletRequest request) {

		System.out.println(request.getHeader("user-agent"));

		preLoginService.validateSignup(signupBean);
		if (signupBean.getErrMap().isEmpty()) {
			signupBean.setSuccess(true);
			preLoginService.execSignup(signupBean);
		} else {
			signupBean.setSuccess(false);
		}
		return signupBean;

	}

	@PostMapping(value = "/validateSignup", produces = "application/json")
	@ResponseBody
	public SignupBean validateSignup(@RequestBody SignupBean signupBean,
			HttpServletRequest request) {

		System.out.println(request.getHeader("user-agent"));

		preLoginService.validateSignup(signupBean);
		if (signupBean.getErrMap().isEmpty()) {
			signupBean.setSuccess(true);
			preLoginService.execSignup(signupBean);
		} else {
			signupBean.setSuccess(false);
		}
		return signupBean;

	}

	@PostMapping(value = "/fp", produces = "application/json")
	@ResponseBody
	public LoginBean forgetPassword(@RequestBody LoginBean loginBean) {
		preLoginService.authorize(loginBean);
		return loginBean;
	}
}
