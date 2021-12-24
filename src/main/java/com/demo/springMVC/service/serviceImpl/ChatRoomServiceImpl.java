package com.demo.springMVC.service.serviceImpl;

import java.util.List;

import com.demo.springMVC.dto.ChatRoom;
import com.demo.springMVC.repository.ChatRoomRepository;
import com.demo.springMVC.service.ChatRoomService;

public class ChatRoomServiceImpl implements ChatRoomService{
	
	private final ChatRoomRepository chatRoomRepository;
	
	public ChatRoomServiceImpl(ChatRoomRepository chatRoomRepository) {
		// TODO Auto-generated constructor stub
		this.chatRoomRepository = chatRoomRepository;
	}

	@Override
	public List<ChatRoom> getUserChatRooms(int userId) {
		// TODO Auto-generated method stub
		return chatRoomRepository.getUserChatRooms(userId);
	}

	@Override
	public void createChatRoom(ChatRoom chatRoom) {
		// TODO Auto-generated method stub
		chatRoomRepository.createChatRoom(chatRoom);
		
	}

	@Override
	public void updateChatRoom(ChatRoom chatRoom) {
		// TODO Auto-generated method stub
		chatRoomRepository.updateChatRoom(chatRoom);
		
	}

	@Override
	public void deleteChatRoom(ChatRoom chatRoom) {
		// TODO Auto-generated method stub
		chatRoomRepository.deleteChatRoom(chatRoom);
		
	}

}
