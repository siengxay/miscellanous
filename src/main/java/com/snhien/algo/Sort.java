package com.snhien.algo;

import java.util.ArrayList;
import java.util.Arrays;

public class Sort {

	public static int[] mergeSortedArrays(int[] a1, int[] a2){
		int[] merged = new int[a1.length + a2.length];
		int c1 = 0, c2 = 0;
		for (int i=c1; i<a1.length; ){
			if (c2<a2.length){
				for (int j=c2; j<a2.length;){
					if (a1[i]<a2[j]){
						merged[c1+c2] = a1[i];
						i++;
						c1 = i;
						break;
					}
					else{
						merged[c1+c2] = a2[j];
						j++;
						c2 = j;
					}
				}
			}
			else{
				merged[c1+c2] = a1[i];
				i++;
			}
		}
		if (c2<a2.length){
			for (int k=c2; k<a2.length; k++){
				merged[c1+c2]=a2[k];
				c2++;
			}
		}
		return (merged);
	}

	public static int[] mergeSortedArrays2(int[] a1, int[] a2){
		int[] merged = new int[a1.length + a2.length];
		int idx1=0, idx2=0, idxMerged = 0;
		
		while (idx1<a1.length){
			while (idx2<a2.length && a2[idx2] < a1[idx1]){
				merged[idxMerged++] = a2[idx2];
				idx2++;
			}
			if (a1[idx1]<=a2[idx2]){
				merged[idxMerged++] = a1[idx1];
				idx1++;
			}
		}
		
		while(idx2<a2.length){
			merged[idxMerged++]=a2[idx2++];
		}
		return(merged);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a1     = new int[]{3, 4, 6, 8, 9, 10, 11, 15};
		int[] a2 = new int[]{1, 5, 8, 12, 14, 19, 23};
		System.out.println( Arrays.toString(mergeSortedArrays2(a1, a2)));
	}

}
