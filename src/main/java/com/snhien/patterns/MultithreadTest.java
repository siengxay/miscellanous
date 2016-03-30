package com.snhien.patterns;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultithreadTest implements Runnable{


	int counter;
	String name;
	
	public MultithreadTest(String name){
		this.name = name;
		
	}

	public void run() {
		synchronized (MultithreadTest.class){
			counter = SingletonEnum.INSTANCE.getCounter();
			SingletonEnum.INSTANCE.increment();
		}
		System.out.println("Thread-" + this.name + " counter=" + counter);

	}
	
	public static void main(String args[]){
		 ExecutorService executor =  Executors.newFixedThreadPool(3);
		 for (int i=0; i<10; i++){
			 MultithreadTest test = new MultithreadTest("test" + i);
			 executor.execute(test);
			 
		 }
		 
	}

}
