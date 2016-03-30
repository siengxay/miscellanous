package com.snhien.algo.euler;

public class Euler1 {
	public static int sumMultipleOf3And5(int max){
		int res = 0;
		for(int i=1; i<max; i++){
			if (i % 3 == 0){
				res += i;
			}
			else if (i % 5 == 0) {
				res += i;
			}
		}
		return res;
	}
	
	
	public static void main(String args[]){
		
		int res = sumMultipleOf3And5(1000);
		System.out.println("Result = " + res);
	}
}
