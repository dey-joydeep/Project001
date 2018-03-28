package com.jd.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jd.app.beans.postlogin.FrameBean;
import com.jd.app.beans.postlogin.MenuBean;
import com.jd.app.beans.postlogin.MessageBean;
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
	public List<MessageBean> loadMessages(@RequestParam String loginId,
			@RequestParam int currentSize, @RequestParam int nextSize) {
		return postLoginService.loadOldMessages(loginId, currentSize, nextSize);

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
}
