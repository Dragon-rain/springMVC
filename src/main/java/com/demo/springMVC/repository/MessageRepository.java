package com.demo.springMVC.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.springMVC.dto.ChatRoom;
import com.demo.springMVC.dto.GlobalMessage;
import com.demo.springMVC.dto.GroupMessage;
import com.demo.springMVC.dto.PrivateMessage;

public interface MessageRepository {
	
	void insertGlobalMessage(@Param("message") GlobalMessage message);

	void insertGroupMessage(@Param("message") GroupMessage message);
	
	void insertPrivateMessage(@Param("message") PrivateMessage message);
	
	List<GlobalMessage> getAllActiveGlobalMessages();
	
	List<GroupMessage> getAllActiveGroupMessages(@Param("chatRoom") ChatRoom chatRoom);
	
	List<PrivateMessage> getAllActivePrivatelMessages(@Param("message") PrivateMessage message);
}
