package com.cyber.cafe.vo;

import java.util.Date;

public class ChatVO {

	private int chatRoomIdx;
	private String chatContent;
	private Date chatTime;
	private String chatNickname;

	public ChatVO() {
		// TODO Auto-generated constructor stub
	}

	public ChatVO(int chatRoomIdx, String chatContent, Date chatTime, String chatNickname) {
		super();
		this.chatRoomIdx = chatRoomIdx;
		this.chatContent = chatContent;
		this.chatTime = chatTime;
		this.chatNickname = chatNickname;
	}

	public int getChatRoomIdx() {
		return chatRoomIdx;
	}

	public void setChatRoomIdx(int chatRoomIdx) {
		this.chatRoomIdx = chatRoomIdx;
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
		return "ChatVO [chatRoomIdx=" + chatRoomIdx + ", chatContent=" + chatContent + ", chatTime=" + chatTime
				+ ", chatNickname=" + chatNickname + "]";
	}

	
	
}
