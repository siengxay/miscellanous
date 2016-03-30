package com.snhien.patterns;

public class Singleton {
	
	private volatile static Singleton instance;
		
	private void Singleton(){
	}
	
	public static Singleton getInstance(){
		if (instance==null){
			synchronized(Singleton.class){
				if (instance==null){
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
	
	
	
	public static void main(String args[]){
		Singleton singleton = Singleton.getInstance();
		SingletonEnum.INSTANCE.increment();
		int counter = SingletonEnum.INSTANCE.getCounter();
		System.out.println("singletonEnum=" + counter);
		
		
		
	}
}
