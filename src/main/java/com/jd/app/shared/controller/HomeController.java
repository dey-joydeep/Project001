package com.jd.app.shared.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jd.app.shared.bean.FrameBean;
import com.jd.app.shared.bean.MenuBean;
import com.jd.app.shared.service.GeneralService;

@Log4j2
@RestController
public class HomeController {

	@Autowired
	GeneralService generalService;

	@GetMapping(value = "/menu", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<MenuBean> loadMenus() {
		log.info("Loading chat menus");

		return generalService.getMenus();
	}

	@GetMapping(value = "/frame", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<FrameBean> loadFrames() {
		log.info("Loading frames");

		return generalService.getFrames();
	}

	@GetMapping(value = "/logout", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		log.info("Logout process invoked");

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
