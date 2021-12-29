package com.demo.springMVC.dto;

public class GlobalMessage extends BaseEntity{
	
	private int senderId;
	private String text;
	
	public static GlobalMessage foromMessageDataToGlobalMessage(MessageData messageData) {
		GlobalMessage globalMessage = new GlobalMessage();
		globalMessage.setSenderId(messageData.getSenderId());
		globalMessage.setText(messageData.getText());
		return globalMessage;
	}
	
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + senderId;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		GlobalMessage other = (GlobalMessage) obj;
		if (senderId != other.senderId)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "{ \"senderId\": \"" + senderId + "\", \"text\": \"" + text + "\"}";
	}
	
}
