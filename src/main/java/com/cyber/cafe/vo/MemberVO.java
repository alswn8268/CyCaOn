package com.cyber.cafe.vo;

import java.util.Date;

public class MemberVO {

	private String id;
	private String password;
	private String nickname;
	private Date sdate;
	
	public MemberVO() {
		// TODO Auto-generated constructor stub
	}

	public MemberVO(String id, String password, String nickname, Date sdate) {
		super();
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		this.sdate = sdate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getSdate() {
		return sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", nickname=" + nickname + ", sdate=" + sdate + "]";
	}
	
	
	
}
