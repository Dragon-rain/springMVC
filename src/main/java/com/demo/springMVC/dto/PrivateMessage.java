package com.demo.springMVC.dto;

public class PrivateMessage extends BaseEntity{
	
	private int senderId;
	private int receiverId;
	private String text;
	
	public static PrivateMessage fromMessageDataToPrivateMessage(MessageData messageData) {
		PrivateMessage privateMessage = new PrivateMessage();
		privateMessage.setSenderId(messageData.getSenderId());
		privateMessage.setReceiverId(messageData.getReceiverId());
		privateMessage.setText(messageData.getText());
		return privateMessage;
	}
	
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public int getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
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
		int result = 1;
		result = prime * result + receiverId;
		result = prime * result + senderId;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrivateMessage other = (PrivateMessage) obj;
		if (receiverId != other.receiverId)
			return false;
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
		return "{ \"senderId\":\"" + senderId + "\", \"receiverId\": \"" + receiverId + "\", \"text\": \"" + text+"\"}";
	}
	

}
