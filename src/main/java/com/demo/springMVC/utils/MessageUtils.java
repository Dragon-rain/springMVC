package com.demo.springMVC.utils;

import java.io.IOException;

import com.demo.springMVC.dto.MessageData;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MessageUtils {
	
	public static MessageData castJsonToMessageData(String json) {
		MessageData messageData = new MessageData();
		ObjectMapper mapper = new ObjectMapper();
			try {
				messageData = mapper.readValue(json, MessageData.class);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return messageData;
	}

}
