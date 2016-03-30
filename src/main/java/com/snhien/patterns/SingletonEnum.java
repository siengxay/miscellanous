package com.snhien.patterns;

public enum SingletonEnum {
	INSTANCE;
	
	private static int counter = 0;
	
	public void increment(){
		counter++;
	}
	
	public int getCounter(){
		return counter;
	}
}
