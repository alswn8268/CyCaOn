package com.cyber.cafe.vo;

import java.util.ArrayList;
import java.util.Date;

public class ChatList {

	private ArrayList<ChatVO> list = new ArrayList<>();

	public ChatList() {
		// TODO Auto-generated constructor stub
	}

	public ChatList(ArrayList<ChatVO> list) {
		super();
		this.list = list;
	}

	public ArrayList<ChatVO> getList() {
		return list;
	}

	public void setList(ArrayList<ChatVO> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "ChatList [list=" + list + "]";
	}
	
	
}
