package com.cyber.cafe.vo;

import java.util.Date;

public class ChatVO {

	private int chatIdx;
	private String chatContent;
	private Date chatTime;
	private String chatNickname;

	public ChatVO() {
		// TODO Auto-generated constructor stub
	}

	public ChatVO(int chatIdx, String chatRoomName, String chatContent, Date chatTime, String chatNickname) {
		super();
		this.chatIdx = chatIdx;
		this.chatContent = chatContent;
		this.chatTime = chatTime;
		this.chatNickname = chatNickname;
	}

	public int getChatIdx() {
		return chatIdx;
	}

	public void setChatIdx(int chatIdx) {
		this.chatIdx = chatIdx;
	}

	public String getChatContent() {
		return chatContent;
	}

	public void setChatContent(String chatContent) {
		this.chatContent = chatContent;
	}

	public Date getChatTime() {
		return chatTime;
	}

	public void setChatTime(Date chatTime) {
		this.chatTime = chatTime;
	}

	public String getChatNickname() {
		return chatNickname;
	}

	public void setChatNickname(String chatNickname) {
		this.chatNickname = chatNickname;
	}

	@Override
	public String toString() {
		return "ChatVO [chatIdx=" + chatIdx + ", chatContent=" + chatContent + ", chatTime=" + chatTime
				+ ", chatNickname=" + chatNickname + "]";
	}

	
}
