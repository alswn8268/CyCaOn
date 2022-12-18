package com.cyber.cafe.vo;

import java.util.ArrayList;

public class FriendList {
	
	private ArrayList<FriendVO> list = new ArrayList<FriendVO>();
	
	public FriendList() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<FriendVO> getList() {
		return list;
	}

	public void setList(ArrayList<FriendVO> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "FriendList [list=" + list + "]";
	}
	
	
	
}
