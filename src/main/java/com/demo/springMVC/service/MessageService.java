package com.demo.springMVC.service;

import java.util.List;

import org.springframework.web.socket.WebSocketSession;

import com.demo.springMVC.dto.ChatRoom;
import com.demo.springMVC.dto.GlobalMessage;
import com.demo.springMVC.dto.GroupMessage;
import com.demo.springMVC.dto.PrivateMessage;

public interface MessageService {
	
	void insertGlobalMessage(GlobalMessage message);

	void insertGroupMessage(GroupMessage message);
	
	void insertPrivateMessage(PrivateMessage message);
	
	List<GlobalMessage> getAllActiveGlobalMessages();
	
	List<GroupMessage> getAllActiveGroupMessages(ChatRoom chatRoom);
	
	List<PrivateMessage> getAllActivePrivatelMessages(PrivateMessage message);
	
	void filterAndSaveMessage(String data);
	
	void filterAndGetMessagesList(String data, WebSocketSession session) throws Exception;

}
