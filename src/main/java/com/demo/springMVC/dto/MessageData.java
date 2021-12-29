package com.demo.springMVC.dto;

public class MessageData {

	private String text;
	private String type;
	private int chatId;
	private String chatMembers;
	private int senderId;
	private int receiverId;
	private String method;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getChatId() {
		return chatId;
	}
	public void setChatId(int chatId) {
		this.chatId = chatId;
	}
	public String getChatMembers() {
		return chatMembers;
	}
	public void setChatMembers(String chatMembers) {
		this.chatMembers = chatMembers;
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
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + chatId;
		result = prime * result + ((chatMembers == null) ? 0 : chatMembers.hashCode());
		result = prime * result + ((method == null) ? 0 : method.hashCode());
		result = prime * result + receiverId;
		result = prime * result + senderId;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		MessageData other = (MessageData) obj;
		if (chatId != other.chatId)
			return false;
		if (chatMembers == null) {
			if (other.chatMembers != null)
				return false;
		} else if (!chatMembers.equals(other.chatMembers))
			return false;
		if (method == null) {
			if (other.method != null)
				return false;
		} else if (!method.equals(other.method))
			return false;
		if (receiverId != other.receiverId)
			return false;
		if (senderId != other.senderId)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MessageData [text=" + text + ", type=" + type + ", chatId=" + chatId + ", chatMembers=" + chatMembers
				+ ", senderId=" + senderId + ", receiverId=" + receiverId + ", method=" + method + "]";
	}
	
}
