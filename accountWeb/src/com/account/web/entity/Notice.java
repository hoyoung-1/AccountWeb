package com.account.web.entity;

import java.util.Date;

public class Notice {

	private int noticeNo;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	
	public Notice() {
		
	}

	public Notice(int noticeNo, String title, String content, String writer, Date regdate) {
		super();
		this.noticeNo = noticeNo;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
	}

	/**
	 * @return the noticeNo
	 */
	public int getNoticeNo() {
		return noticeNo;
	}

	/**
	 * @param noticeNo the noticeNo to set
	 */
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
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

	@Override
	public String toString() {
		return "NoticeService [noticeNo=" + noticeNo + ", title=" + title + ", content=" + content + ", writer="
				+ writer + ", regdate=" + regdate + "]";
	}
	
	
}
