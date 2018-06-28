package com.jd.app.modules.chat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jd.app.modules.chat.bean.ChatDetailsBean;
import com.jd.app.modules.chat.service.ChatService;
import com.jd.app.shared.bean.UserDetailsBean;

@RestController
public class ChatController {

	@Autowired
	ChatService chatService;

	@GetMapping(value = "/users", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<UserDetailsBean> loadUsers(@RequestParam String loginId) {
		return chatService.loadUsers(loginId);
	}

	@GetMapping(value = "/messages", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public ChatDetailsBean loadMessages(@RequestParam String loginId, @RequestParam String friendId,
			@RequestParam int currentSize, @RequestParam int nextSize) {

		return chatService.loadMessages(loginId, friendId, currentSize, nextSize);
	}
}
