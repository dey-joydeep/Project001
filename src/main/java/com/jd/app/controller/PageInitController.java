package com.jd.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jd.app.beans.postlogin.UserDetailsBean;
import com.jd.app.beans.prelogin.LoginBean;

@Controller
public class PageInitController {

	@GetMapping(value = "/")
	public String showLogin(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("loginId") == null) {
			model.addAttribute("login", new LoginBean());
			return "login";
		} else {
			model.addAttribute("user", new UserDetailsBean());
			return "home";
		}
	}

	@GetMapping("/chat")
	public String showHomePage(Model model) {
		model.addAttribute("user", new UserDetailsBean());
		return "frames/chat";
	}
}
