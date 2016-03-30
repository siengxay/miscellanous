package com.snhien.algo;

import java.util.Arrays;

public class WiggleSort {
	int[] nums;
	
	public WiggleSort(int[] nums){
		this.nums = nums;
	}
	
	public void wiggleSort(){
		for (int i=0; i<nums.length; i++){
			wiggleSort(i);
		}
	}
	
	protected void wiggleSort(int i){
		if (i%2==0){//even i<i+1
			if(i<nums.length-1){
				if(nums[i] > nums[i+1]){
					swap(i, i+1);
				}
			}
		}else{//odd i>i+1
			if(i<nums.length-1){
				if(nums[i]<nums[i+1]){
					swap(i, i+1);
				}
			}
		}
	}
	
	public void swap(int i, int j){
		int tmp = nums[j];
		nums[j]=nums[i];
		nums[i]=tmp;
	}
	
	public String toString(){
		return( Arrays.toString(nums) );
	}
	
	public static void main(String args[]){
		int[] nums = new int[]{1, 5, 1, 1, 6, 4};
		WiggleSort ws = new WiggleSort(nums);
		System.out.println(ws.toString());
		ws.wiggleSort();
		System.out.println(ws.toString());
		
	}
}
