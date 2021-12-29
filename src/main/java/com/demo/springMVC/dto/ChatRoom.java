package com.demo.springMVC.dto;

public class ChatRoom extends BaseEntity{
	private String members;

	public static ChatRoom fromMassageDataToChatRoomData(MessageData data) {
		ChatRoom chatRoom = new ChatRoom();
		chatRoom.setId(data.getChatId());
		return chatRoom;
	}
	
	public String getMembers() {
		return members;
	}

	public void setMembers(String members) {
		this.members = members;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((members == null) ? 0 : members.hashCode());
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
		ChatRoom other = (ChatRoom) obj;
		if (members == null) {
			if (other.members != null)
				return false;
		} else if (!members.equals(other.members))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ChatRoom [members=" + members + "]";
	} 
	
}
