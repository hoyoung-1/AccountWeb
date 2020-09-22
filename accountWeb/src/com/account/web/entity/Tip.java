package com.account.web.entity;

import java.util.Date;

public class Tip {

	private int userId;
	private int tipId;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private int hit;

	public Tip() {
		
	}
	

	public Tip(int userId, int tipId, String title, String content, String writer, Date regdate, int hit) {
		super();
		this.userId = userId;
		this.tipId = tipId;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
		this.hit = hit;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the tipId
	 */
	public int getTipId() {
		return tipId;
	}
	/**
	 * @param tipId the tipId to set
	 */
	public void setTipId(int tipId) {
		this.tipId = tipId;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the writer
	 */
	public String getWriter() {
		return writer;
	}
	/**
	 * @param writer the writer to set
	 */
	public void setWriter(String writer) {
		this.writer = writer;
	}
	/**
	 * @return the regdate
	 */
	public Date getRegdate() {
		return regdate;
	}
	/**
	 * @param regdate the regdate to set
	 */
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	/**
	 * @return the hit
	 */
	public int getHit() {
		return hit;
	}
	/**
	 * @param hit the hit to set
	 */
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	@Override
	public String toString() {
		return "Tip [userId=" + userId + ", tipId=" + tipId + ", title=" + title + ", content=" + content + ", writer="
				+ writer + ", regdate=" + regdate + ", hit=" + hit + "]";
	}
	
}
