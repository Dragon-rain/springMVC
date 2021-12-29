package com.demo.springMVC.dto;

public class GroupMessage extends BaseEntity{
	
	private int senderId;
	private String text;
	private int chatRoomId;
	
	public static GroupMessage fromMessageDataToGroupMessage(MessageData messageData) {
		GroupMessage groupMessage = new GroupMessage();
		groupMessage.setSenderId(messageData.getSenderId());
		groupMessage.setText(messageData.getText());
		groupMessage.setChatRoomId(messageData.getChatId());
		return groupMessage;
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
	public int getChatRoomId() {
		return chatRoomId;
	}
	public void setChatRoomId(int chatRoomId) {
		this.chatRoomId = chatRoomId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + chatRoomId;
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
		GroupMessage other = (GroupMessage) obj;
		if (chatRoomId != other.chatRoomId)
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
		return "GroupMessage [senderId=" + senderId + ", text=" + text + ", chatRoomId=" + chatRoomId + "]";
	}
	
	

}
