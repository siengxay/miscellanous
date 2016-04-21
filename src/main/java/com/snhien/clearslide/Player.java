package com.snhien.clearslide;

public class Player {
	int id;
	int pos;
	
	public Player(int id){
		this.id = id;
		pos = 0;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
}
