package com.demo.springMVC.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class SocketServer extends TextWebSocketHandler {
	
	private static List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	
	public SocketServer() {
		System.out.println("server started" + SocketServer.class);
	}

	/*
	 * @OnOpen public void onOpen(Session curSession) {
	 * userSessions.add(curSession); }
	 * 
	 * @OnClose public void onClose(Session curSession) {
	 * userSessions.remove(curSession); }
	 * 
	 * @OnMessage public void onMessage(String message, Session userSession) {
	 * for(Session ses : userSessions) { ses.getAsyncRemote().sendText(message); } }
	 * 
	 * @OnError public void onError(Throwable e) { e.printStackTrace(); }
	 */
    
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
      sessionList.add(session);
      System.out.println("{} 연결됨"+ session.getId());
    }
   
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
      System.out.println(("{}로 부터 {} 받음"+ session.getId()+ message.getPayload()));
      String messagedata = message.getPayload();
      for (WebSocketSession sess : sessionList) {
        sess.sendMessage(new TextMessage(session.getId() + " : " + message.getPayload()));
      }
    }
    
    
    
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
      sessionList.remove(session);
      System.out.println(("{} 연결 끊김"+ session.getId()));
    }

}
