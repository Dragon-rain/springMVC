package com.demo.springMVC.service;

import java.util.List;

import com.demo.springMVC.dto.ChatRoom;

public interface ChatRoomService {
	
	List<ChatRoom> getUserChatRooms(int userId);
	
	void createChatRoom(ChatRoom chatRoom);
	
	void updateChatRoom(ChatRoom chatRoom);
	
	void deleteChatRoom(ChatRoom chatRoom);

}
