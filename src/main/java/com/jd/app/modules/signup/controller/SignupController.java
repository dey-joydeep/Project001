package com.jd.app.modules.signup.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jd.app.modules.signup.bean.SignupBean;
import com.jd.app.modules.signup.service.SignupService;
import com.jd.app.shared.constants.LogicConstants;

@RestController
public class SignupController {

	@Autowired
	SignupService signupService;

	@PostMapping(value = "/signup", produces = "application/json")
	@ResponseBody
	public SignupBean signup(@RequestBody SignupBean signupBean,
			HttpServletRequest request) {

		System.out.println(request.getHeader("user-agent"));

		signupService.validateSignup(signupBean);
		if (signupBean.getErrMap().isEmpty()) {
			signupBean.setSuccess(true);
			long loginId = signupService.execSignup(signupBean);
			HttpSession session = request.getSession();
			session.setAttribute(LogicConstants.SESSION_ATTR_LOGIN_ID, loginId);
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

		signupService.validateSignup(signupBean);
		if (signupBean.getErrMap().isEmpty()) {
			signupBean.setSuccess(true);
		} else {
			signupBean.setSuccess(false);
		}
		return signupBean;
	}
}
