package com.snhien.algo.leetcode;

import java.util.*;

public class NumArray {

	int[]  nums;
	
    public NumArray(int[] nums) {
    	this.nums = nums;
    }
    

    public int sumRange(int i, int j) {
    	int res = 0;
    	if (i>j || i<0 || j>=nums.length ){
    		throw new RuntimeException();
    	}
    	for(int k=i; k<=j; k++){
    		res += nums[k];
    	}
    	return(res);
    }
    
    
    //Find largest sum of contiguous elements in array - Kadane's algorithm
    public static int getMaxSubArray(int[] array){
    	int maxSoFar = array[0];
    	int maxHere = array[0];
    	for (int i=0; i<array.length; i++){
    		maxHere = Math.max(array[i], maxHere + array[i]);
    		maxSoFar = Math.max(maxHere, maxSoFar);
    	}
    	return (maxSoFar);
    }
    
    public static boolean increasingTriplet(int[] nums) {
    	/*
    	boolean res = false;
    	int first = Integer.MAX_VALUE;
    	int second = Integer.MAX_VALUE;
    	for (int num: nums){
    		if (num<=first){
    			first = num;
    			if (num<second){
    				second = num;
    			}
    			else{
    				res = true;
    			}
    		}
    		
    	}
    	return res;
    	*/
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for(int num : nums){
            if(num <= min) min = num;
            else if(num < secondMin) secondMin = num;
            else if(num > secondMin) return true;
        }
        return false;
    }
    
    public static int getNthLargest(int[] A, int n){
    	if (n>A.length) throw new RuntimeException("OutOfBound n=" + n);
    	Arrays.sort(A);
    	int res = A[A.length - n];
    	return (res);
    }
    
    public static List<List<Integer>>getPermutations(int[] A){
    	List<List<Integer>> permutations = new ArrayList<List<Integer>>();
    	getPermutationsRecursive(A, 0, new ArrayList<Integer>(), permutations);
    	return permutations;
    }
    
    protected static void getPermutationsRecursive(int[] A, int pivot, 
    			List<Integer> permutation, 
    			List<List<Integer>> permutations ){
    	if (permutation.size()>=A.length || pivot >= A.length){
    		permutations.add(permutation);
    		return;
    	}
	    	for (int i=0; i<A.length; i++){
	    		List<Integer> newPerm = new ArrayList<Integer>(permutation);
	    		newPerm.add(i, A[pivot]);
	    		getPermutationsRecursive(A, pivot+1, newPerm, permutations);
	    	}
    }
    //A={1,2,3}
    //pivot=0, i=0 newPerm={1}
    //	pivot=1, i=0: newPerm={2,1}
    //	pivot=1, i=1: newPerm={1,2}
    //	pivot=1, i=2: newPerm={1,?,2}
    
    
    public static void main(String args[]){
    	NumArray numArray = new NumArray (new int[]{-2, 0, 3, -5, 2, -1});
    	System.out.println(" (0,2)=" + numArray.sumRange(0,5));
    	
    	boolean increasingTriplet = increasingTriplet(new int[]{4,7,2,3,1,0});
    	System.out.println("increasingTriplets=" + increasingTriplet);
    	
//    	int nthLargest = getNthLargest(new int[]{1,8,4,55,6,7,3}, 0);
//    	System.out.println("nthLargest = " + nthLargest);
    	
    	List<List<Integer>> permutations = getPermutations(new int[]{1,2,3});
    	System.out.println("Number of permutations = " + permutations.size());
    	
    	int maxSubArray = getMaxSubArray(new int[]{-160, -20});
    	System.out.println("MaxSubArray=" + maxSubArray);
    }
}
