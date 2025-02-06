package personalproject.dto;

import java.sql.Timestamp;

public class CommentsDto {
	private long cmtId;
	private int postId;
	private String writer;
	private int likeCnt;
	private int dislikeCnt;
	private Timestamp createdAt;
	
	public long getCmtId() {
		return cmtId;
	}
	public void setCmtId(long cmtId) {
		this.cmtId = cmtId;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getLikeCnt() {
		return likeCnt;
	}
	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}
	public int getDislikeCnt() {
		return dislikeCnt;
	}
	public void setDislikeCnt(int dislikeCnt) {
		this.dislikeCnt = dislikeCnt;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
}
