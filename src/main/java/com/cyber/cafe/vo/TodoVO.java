package com.cyber.cafe.vo;

public class TodoVO {

	private String id;
	private String todo;
	
	public TodoVO() {
		// TODO Auto-generated constructor stub
	}

	public TodoVO(String id, String todo) {
		super();
		this.id = id;
		this.todo = todo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	@Override
	public String toString() {
		return "TodoVO [id=" + id + ", todo=" + todo + "]";
	}

	
}
