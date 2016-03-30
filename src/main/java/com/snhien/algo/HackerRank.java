package com.snhien.algo;

import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Scanner;

public class HackerRank {
	/**
	 * Fibonacci Modified
	 * https://www.hackerrank.com/challenges/fibonacci-modified
	 * Given the nth and (n+1)th terms, the (n+2)th can be computed by the following relation 
	 * Tn+2 = (Tn+1)2 + Tn
	 * a and b are first 2 terms of series (T0 and T1)
	 */
	public static BigInteger getFiboModif(int a, int b, int n){
		if (n==1){
			return BigInteger.valueOf(a);
		}
		if (n==2){
			return BigInteger.valueOf(b);
		}
		BigInteger prev = getFiboModif(a,b, n-1);
		prev = prev.pow(2);
		BigInteger res = prev.add(getFiboModif(a,b,n-2));
		return res;
		
	}
	
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int n = in.nextInt();
		BigInteger res = getFiboModif(a,b,n);
		System.out.println(res.toString());
		
	}
}
