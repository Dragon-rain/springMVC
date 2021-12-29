package com.demo.springMVC.service.serviceImpl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.demo.springMVC.dto.ChatRoom;
import com.demo.springMVC.dto.GlobalMessage;
import com.demo.springMVC.dto.GroupMessage;
import com.demo.springMVC.dto.MessageData;
import com.demo.springMVC.dto.MessageTypes;
import com.demo.springMVC.dto.PrivateMessage;
import com.demo.springMVC.repository.MessageRepository;
import com.demo.springMVC.service.MessageService;
import com.demo.springMVC.utils.DateUtil;
import com.demo.springMVC.utils.MessageUtils;

public class MessageServiceImpl implements MessageService {
	
	private  MessageRepository messageRepository;

	public MessageRepository getMessageRepository() {
		return messageRepository;
	}

	public void setMessageRepository(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	@Override
	public void insertGlobalMessage(GlobalMessage message) {
		// TODO Auto-generated method stub
		message.setCreated(DateUtil.getCurrentSqlDate());
		messageRepository.insertGlobalMessage(message);
		
	}

	@Override
	public void insertGroupMessage(GroupMessage message) {
		// TODO Auto-generated method stub
		message.setCreated(DateUtil.getCurrentSqlDate());
		messageRepository.insertGroupMessage(message);
		
	}

	@Override
	public void insertPrivateMessage(PrivateMessage message) {
		// TODO Auto-generated method stub
		message.setCreated(DateUtil.getCurrentSqlDate());
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

	@Override
	public void filterAndSaveMessage(String data) {
		MessageData messageData = MessageUtils.castJsonToMessageData(data);
		String messageType = messageData.getType();
		if(messageType.equals(MessageTypes.GLOBAL.toString())) {
			insertGlobalMessage(GlobalMessage.foromMessageDataToGlobalMessage(messageData));
		} else if (messageType.equals(MessageTypes.GROUP.toString())) {
			insertGroupMessage(GroupMessage.fromMessageDataToGroupMessage(messageData));
		} else if (messageType.equals(MessageTypes.PRIVATE.toString())) {
			insertPrivateMessage(PrivateMessage.fromMessageDataToPrivateMessage(messageData));
		}
		
	}

	@Override
	public void filterAndGetMessagesList(String data, WebSocketSession session) throws Exception {
		MessageData messageData = MessageUtils.castJsonToMessageData(data);
		String messageType = messageData.getType();
		if(messageType.equals(MessageTypes.GLOBAL.toString())) {
			session.sendMessage(new TextMessage(getAllActiveGlobalMessages().toString()));
		} else if (messageType.equals(MessageTypes.GROUP.toString())) {
			session.sendMessage(new TextMessage(getAllActiveGroupMessages(ChatRoom.fromMassageDataToChatRoomData(messageData)).toString()));
		} else if (messageType.equals(MessageTypes.PRIVATE.toString())) {
			session.sendMessage(new TextMessage(getAllActivePrivatelMessages(PrivateMessage.fromMessageDataToPrivateMessage(messageData)).toString()));
		}
		
	}

}
