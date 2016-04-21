package com.snhien.clearslide;

import java.util.List;
import java.util.Map;

public class Board {
	int[] pos;
	
	Map<Integer, BaseSnake> snakeLadders;
	
	public Board(int size, Map<Integer, BaseSnake> snakeLadders){
		this.pos = new int[size];
		this.snakeLadders = snakeLadders;
	}
	
	public Map<Integer, BaseSnake> getSnakeLadders() {
		return snakeLadders;
	}


	public void setSnakeLadders(Map<Integer, BaseSnake> snakeLadders) {
		this.snakeLadders = snakeLadders;
	}


	public int getEndPos(){
		return (pos.length - 1);
	}
	
}
