package com.cyber.cafe.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.cyber.cafe.vo.FriendList;
import com.cyber.cafe.vo.FriendVO;
import com.cyber.cafe.vo.MemberVO;
import com.cyber.cafe.vo.RoomVO;

public interface MyBatisDAO {

	// member
	void joinmember(MemberVO memberVO);
	MemberVO getId(String id);

	// room
	void makeNewRoom(RoomVO roomVO);
	RoomVO getRoomInfo(String roomHost);
	int roomExist(String id);
	void deleteExistance(String id);
	ArrayList<RoomVO> getRooms(String roomHost);
	int selectRoomCount();
	ArrayList<RoomVO> getRoomList(HashMap<String, Integer> hmap);

	// friend
	void friendRequest(FriendVO friendVO);
	int counterRequest(FriendVO friendVO);
	void changeRelation(FriendVO friendVO);
	String getRel(FriendVO friendVO);
	void deleteFriend(FriendVO friendVO);
	ArrayList<FriendVO> getFriendList(String id);
	
	
}
