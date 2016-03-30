package com.snhien.algo;

public class SumRange {

	int[] nums;
	
	public SumRange(int[] nums){
		this.nums = nums;
	}
	
	public int sumRange(int i, int j){
		int res = 0;
		for (int c=i; c<=j; c++){
			res+= nums[c];
		}
		System.out.println("[" + i + "," + j + "]=" + res);
		return(res);
	}
	
	public void update(int i, int val) throws Exception{
		nums[i] = val;
	}
	
	public static void main(String[] args){
		int[] nums = new  int[]{1,3,5};
		SumRange sr = new SumRange(nums);
		
		try{
			sr.sumRange(0, 2);
			sr.update(1, 2);
			sr.sumRange(0, 2);
		}
		catch(Exception e){
			System.out.println("Exception :" + e.toString());
		}
	}
}
