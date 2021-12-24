package com.demo.springMVC.service.serviceImpl;

import java.util.List;

import com.demo.springMVC.dto.ChatRoom;
import com.demo.springMVC.dto.GlobalMessage;
import com.demo.springMVC.dto.GroupMessage;
import com.demo.springMVC.dto.PrivateMessage;
import com.demo.springMVC.repository.MessageRepository;
import com.demo.springMVC.service.MessageService;

public class MessageServiceImpl implements MessageService {
	
	private final MessageRepository messageRepository;
	
	public MessageServiceImpl(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	@Override
	public void insertGlobalMessage(GlobalMessage message) {
		// TODO Auto-generated method stub
		messageRepository.insertGlobalMessage(message);
		
	}

	@Override
	public void insertGroupMessage(GroupMessage message) {
		// TODO Auto-generated method stub
		messageRepository.insertGroupMessage(message);
		
	}

	@Override
	public void insertPrivateMessage(PrivateMessage message) {
		// TODO Auto-generated method stub
		messageRepository.insertPrivateMessage(message);
		
	}

	@Override
	public List<GlobalMessage> getAllActiveGlobalMessages() {
		// TODO Auto-generated method stub
		return messageRepository.getAllActiveGlobalMessages();
	}

	@Override
	public List<GroupMessage> getAllActiveGroupMessages(ChatRoom chatRoom) {
		// TODO Auto-generated method stub
		return messageRepository.getAllActiveGroupMessages(chatRoom);
	}

	@Override
	public List<PrivateMessage> getAllActivePrivatelMessages(PrivateMessage message) {
		// TODO Auto-generated method stub
		return messageRepository.getAllActivePrivatelMessages(message);
	}

}
