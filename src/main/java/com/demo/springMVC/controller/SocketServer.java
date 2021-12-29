package com.demo.springMVC.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.demo.springMVC.dto.GlobalMessage;
import com.demo.springMVC.dto.MessageData;
import com.demo.springMVC.service.MessageService;
import com.demo.springMVC.utils.MessageUtils;

public class SocketServer extends TextWebSocketHandler {
	
	private MessageService messageService;
	
	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	private static List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	
	public SocketServer() {
		System.out.println("server started" + SocketServer.class);
	}
	
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
      sessionList.add(session);
      List<GlobalMessage> globalMessagesList = messageService.getAllActiveGlobalMessages();
      session.sendMessage(new TextMessage(globalMessagesList.toString()));
      System.out.println(globalMessagesList);
    }
   
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
      String messagedata = message.getPayload();
      MessageData data = MessageUtils.castJsonToMessageData(messagedata);
      if(data.getMethod().equals("POST")) {
    	  messageService.filterAndSaveMessage(messagedata);
          for (WebSocketSession sess : sessionList) {
            sess.sendMessage(new TextMessage(messagedata));
          }
      } else if (data.getMethod().equals("GET")) {
    	  System.out.println(data);
    	  messageService.filterAndGetMessagesList(messagedata, session);
      }
      
    }
    
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
      sessionList.remove(session);
      System.out.println(("{} 연결 끊김"+ session.getId()));
    }

}