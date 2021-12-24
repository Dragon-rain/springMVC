package com.demo.springMVC.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.springMVC.dto.ChatRoom;

public interface ChatRoomRepository {
	
	List<ChatRoom> getUserChatRooms(@Param("userId") int userId);
	
	void createChatRoom(@Param("chatRoom") ChatRoom chatRoom);
	
	void updateChatRoom(@Param("chatRoom") ChatRoom chatRoom);
	
	void deleteChatRoom(@Param("chatRoom") ChatRoom chatRoom);

}
