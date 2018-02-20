package com.snhien.algo;

public class DynamicProgramming {

	
	/*
	 * You are climbing a stair case. It takes n steps to reach to the top.
	 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
	 * a=0 -> 0
	 * a=1 -> 1
	 * a=2 -> {1,1}, {2} -> 2
	 * a=3 -> {1,1,1}, {1,2}, {2,1} -> 3
	 * a=4 -> {1,1,1,1}, {1,1,2}, {1,2,1}, {2,1,1}, {2, 2} -> 5
	 * a=5 -> {1,1,1,1,1}, {1,1,1,2}, {1,1,2,1}, {1,2,1,1}, {2,1,1,1}, {1,2,2}, {2,1,2}, {2,2,1} -> 8
	 */
	public int climbStairs1(int a) {
	    int[] memo = new int[a+1];
	    return climb1(0, a, memo);
	}
	
	private int climb1(int i, int a, int[] memo){
	    if (i>a){
	        return 0;
	    }
	    else if (i==a){
	        return 1;
	    }
	    else{
	        memo[i] = climb1(i+1, a, memo) + climb1(i+2, a, memo);
	    }
	    return memo[i];
	}
	
	
	
}
