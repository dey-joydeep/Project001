package com.jd.app.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jd.app.beans.postlogin.UserDetailsBean;
import com.jd.app.beans.prelogin.LoginBean;
import com.jd.app.beans.prelogin.SignupBean;

@Controller
public class PageInitController {

	@GetMapping(value = "/")
	public String showLogin(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("loginId") == null) {
			String[] cookieValues = new String[2];
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					if ("login-cookie".equals(cookies[i].getName())) {
						cookieValues = cookies[i].getValue().split("-");
						break;
					}
				}
			}
			if ("1".equals(cookieValues[1])) {
				session = request.getSession(true);
				session.setAttribute("loginId", cookieValues[0]);
			} else {
				model.addAttribute("login", new LoginBean());
				return "login";
			}
		}

		UserDetailsBean userBean = new UserDetailsBean();
		userBean.setUsername(session.getAttribute("loginId").toString());
		model.addAttribute("user", userBean);
		return "home";
	}

	@GetMapping(value = "/signup")
	public String showSignup(Model model, HttpServletRequest request) {

		String ua = request.getHeader("user-agent");
		System.out.println(ua);

		SignupBean signUpBean = new SignupBean();
		if (ua.toLowerCase().contains("iphone"))
			signUpBean.setDeviceType((short) 1);
		signUpBean.setPageVal((short) 1);
		signUpBean.setLoginMode((short) 1);
		model.addAttribute("signup", signUpBean);
		return "signup";
	}

	@GetMapping("/chat")
	public String showHomePage(Model model) {
		model.addAttribute("user", new UserDetailsBean());
		return "frames/chat";
	}

	@GetMapping("/settings")
	public String showSettingsPage(Model model) {
		model.addAttribute("user", new UserDetailsBean());
		return "frames/settings";
	}
}
