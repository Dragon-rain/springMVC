package com.demo.springMVC.controller;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.WebSocketSession;

import com.demo.springMVC.service.MessageService;

public class StartServer {
	
private MessageService messageService;
	
	private static StartServer instanse;

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	
	private static List<Socket> sessionList = new ArrayList<Socket>();
	
	private StartServer() {
		// TODO Auto-generated constructor stub
	System.out.println("server initialized");
	}
	
	public static StartServer getInstance() {
		if(instanse == null) {
			instanse = new StartServer();
			
		}
		return instanse;
	}
	
	public void startServer() {
		ServerSocket server = null;
	    Socket socket = null;
		OutputStream out = null;
		InputStream in = null;
		
	    try {
            server = new ServerSocket(2010);
            System.out.println("Server Started. Waiting for connection ...");
            socket = server.accept();
            System.out.println("Got connection from client.");
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
