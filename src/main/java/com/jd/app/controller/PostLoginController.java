package com.jd.app.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jd.app.beans.postlogin.ChatDetailsBean;
import com.jd.app.beans.postlogin.FrameBean;
import com.jd.app.beans.postlogin.MenuBean;
import com.jd.app.beans.postlogin.UserDetailsBean;
import com.jd.app.service.def.PostLoginService;

@RestController
public class PostLoginController {

	@Autowired
	PostLoginService postLoginService;

	@GetMapping(value = "/users", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<UserDetailsBean> loadUsers(@RequestParam String loginId) {
		return postLoginService.loadUsers(loginId);
	}

	@GetMapping(value = "/messages", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public ChatDetailsBean loadMessages(@RequestParam String loginId, @RequestParam String friendId,
			@RequestParam int currentSize, @RequestParam int nextSize) {

		return postLoginService.loadMessages(loginId, friendId, currentSize, nextSize);

	}

	@GetMapping(value = "/menu", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<MenuBean> loadMenus() {
		return postLoginService.getMenus();
	}

	@GetMapping(value = "/frame", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<FrameBean> loadFrames() {
		return postLoginService.getFrames();
	}

	@GetMapping(value = "/logout", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.removeAttribute("loginId");
			session.invalidate();
		}
		
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			if ("login-cookie".equals(cookies[i].getName())) {
				cookies[i].setValue("");
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
				break;
			}
		}
		return;
	}
}
