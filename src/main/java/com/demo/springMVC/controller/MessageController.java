package com.demo.springMVC.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.demo.springMVC.dto.ChatRoom;
import com.demo.springMVC.dto.GroupMessage;
import com.demo.springMVC.dto.PrivateMessage;
import com.demo.springMVC.service.MessageService;

public class MessageController implements Controller{
	
	private final MessageService messageService;
	
	public MessageController(MessageService messageService) {
		this.messageService = messageService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getAttribute("chatData")!=null) request.removeAttribute("chatData");
		if(request.getRequestURI().contains("/global")) {
			request.setAttribute("chatData", messageService.getAllActiveGlobalMessages());
		} else if (request.getRequestURI().contains("/group")) {
			ChatRoom chatRoom = new ChatRoom();
			chatRoom.setId(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("chatData", messageService.getAllActiveGroupMessages(chatRoom));
		} else if (request.getRequestURI().contains("/private")) {
			PrivateMessage message = new PrivateMessage();
			message.setReceiverId(Integer.parseInt(request.getParameter("receiver")));
			message.setSenderId(Integer.parseInt(request.getParameter("sender")));
			request.setAttribute("chatData", messageService.getAllActivePrivatelMessages(message));
		}
		return null;
	}

}
