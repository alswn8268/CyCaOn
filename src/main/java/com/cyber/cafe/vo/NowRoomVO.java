package com.cyber.cafe.vo;

public class NowRoomVO {

	private String id;
	private int roomIdx;
	private String sessionInfo;
	
	public NowRoomVO() {
		// TODO Auto-generated constructor stub
	}

	public NowRoomVO(String id, int roomIdx, String sessionInfo) {
		super();
		this.id = id;
		this.roomIdx = roomIdx;
		this.sessionInfo = sessionInfo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getRoomIdx() {
		return roomIdx;
	}

	public void setRoomIdx(int roomIdx) {
		this.roomIdx = roomIdx;
	}

	public String getSessionInfo() {
		return sessionInfo;
	}

	public void setSessionInfo(String sessionInfo) {
		this.sessionInfo = sessionInfo;
	}

	@Override
	public String toString() {
		return "NowRoomVO [id=" + id + ", roomIdx=" + roomIdx + ", sessionInfo=" + sessionInfo + "]";
	}
	
	
}
