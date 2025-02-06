package personalproject.dto;

import java.sql.Timestamp;

public class MessagesDto {
	private long msgId;
	private String senderId;
	private String receiverId;
	private String contents;
	private boolean isRead;
	private Timestamp sendAt;
	public long getMsgId() {
		return msgId;
	}
	public void setMsgId(long msgId) {
		this.msgId = msgId;
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public boolean isRead() {
		return isRead;
	}
	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}
	public Timestamp getSendAt() {
		return sendAt;
	}
	public void setSendAt(Timestamp sendAt) {
		this.sendAt = sendAt;
	}
	
}
