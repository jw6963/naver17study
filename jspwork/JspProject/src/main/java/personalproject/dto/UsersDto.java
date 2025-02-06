package personalproject.dto;

import java.sql.Timestamp;

public class UsersDto {
	private int sequence;
	private String userId;
	private String passwd;
	private String role;
	private Timestamp suspension;
	private Timestamp createdAt;
	
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Timestamp getSuspension() {
		return suspension;
	}
	public void setSuspension(Timestamp suspension) {
		this.suspension = suspension;
	}
}
