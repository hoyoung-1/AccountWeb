package com.account.web.entity;

import java.util.Date;

public class Users {

	private int userNo;
	private String id;
	private String pw;
	private String name;
	private Date regdate;
	
	public Users() {
		
	}
	
	public Users(int userNo, String id, String pw, String name, Date regdate) {
		super();
		this.userNo = userNo;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.regdate = regdate;
	}
	
	/**
	 * @return the userNo
	 */
	public int getUserNo() {
		return userNo;
	}
	/**
	 * @param userNo the userNo to set
	 */
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the pw
	 */
	public String getPw() {
		return pw;
	}
	/**
	 * @param pw the pw to set
	 */
	public void setPw(String pw) {
		this.pw = pw;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
		return "Users [userNo=" + userNo + ", id=" + id + ", pw=" + pw + ", name=" + name + ", regdate=" + regdate
				+ "]";
	}
	
	
}
