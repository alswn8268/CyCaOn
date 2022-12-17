package com.cyber.cafe.vo;

public class RoomVO {

	private int roomIdx;
	private String roomHost;
	private String roomName;
	private int roomPassword;
	private String roomTheme;
	private String roomGuest;
	
	public RoomVO() {

	}

	public RoomVO(int roomIdx, String roomHost, String roomName, int roomPassword, String roomTheme, String roomGuest) {
		super();
		this.roomIdx = roomIdx;
		this.roomHost = roomHost;
		this.roomName = roomName;
		this.roomPassword = roomPassword;
		this.roomTheme = roomTheme;
		this.roomGuest = roomGuest;
	}

	public int getRoomIdx() {
		return roomIdx;
	}

	public void setRoomIdx(int roomIdx) {
		this.roomIdx = roomIdx;
	}

	public String getRoomHost() {
		return roomHost;
	}

	public void setRoomHost(String roomHost) {
		this.roomHost = roomHost;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getRoomPassword() {
		return roomPassword;
	}

	public void setRoomPassword(int roomPassword) {
		this.roomPassword = roomPassword;
	}

	public String getRoomTheme() {
		return roomTheme;
	}

	public void setRoomTheme(String roomTheme) {
		this.roomTheme = roomTheme;
	}

	public String getRoomGuest() {
		return roomGuest;
	}

	public void setRoomGuest(String roomGuest) {
		this.roomGuest = roomGuest;
	}

	@Override
	public String toString() {
		return "RoomVO [roomIdx=" + roomIdx + ", roomHost=" + roomHost + ", roomName=" + roomName + ", roomPassword="
				+ roomPassword + ", roomTheme=" + roomTheme + ", roomGuest=" + roomGuest + "]";
	}	
	
}
