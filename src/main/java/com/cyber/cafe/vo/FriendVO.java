package com.cyber.cafe.vo;

public class FriendVO {

	private String mid;
	private String fid;
	private String relation;
	
	public FriendVO() {
	
	}

	public FriendVO(String mid, String fid, String relation) {
		super();
		this.mid = mid;
		this.fid = fid;
		this.relation = relation;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	@Override
	public String toString() {
		return "FriendVO [mid=" + mid + ", fid=" + fid + ", relation=" + relation + "]";
	}

	
	
}
