package com.snhien.algo;

import java.util.Arrays;

public class StockPrice {

	// returns 6 (buying for $5 and selling for $11)
	public static int getMaxProfit(int[] stockPricesYesterday){
		int maxProfit = Integer.MIN_VALUE;
		for(int i=0; i<stockPricesYesterday.length -1; i++){
			for (int j=i+1; j<stockPricesYesterday.length;  j++){
				int profit = stockPricesYesterday[j] - stockPricesYesterday[i];
				if (profit>maxProfit){
					maxProfit = profit;
				}
			}
		}
		return(maxProfit);
	}	
	
	public static int getMaxProfit2(int[] stockPricesYesterday){
		int maxProfit = Integer.MIN_VALUE;
		for(int i=0; i<stockPricesYesterday.length -1; i++){
			int[] tail = Arrays.copyOfRange(stockPricesYesterday, i, stockPricesYesterday.length);
			Arrays.sort(tail);
			int maxTail = tail[tail.length-1];
			int profit = maxTail - stockPricesYesterday[i];
			if (maxProfit<profit){
				maxProfit = profit;
			}
		}
		return(maxProfit);
	}
	
	public static int getMaxProfit3(int[] stockPricesYesterday){
		int minPrice = stockPricesYesterday[0];
		int maxProfit = stockPricesYesterday[1] - minPrice;
		for(int i=1; i<stockPricesYesterday.length -1 ; i++){
			minPrice = Math.min(minPrice, stockPricesYesterday[i]);
			maxProfit = Math.max(maxProfit, stockPricesYesterday[i+1] - minPrice);
		}
		return (maxProfit);
	}
	
	
	public static int getMaxProfit4(int[] stockPrices, int K){
		int maxProfit = 0;
		int[][] dp = new int[K+1][stockPrices.length];
		for (int kk=1; kk<=K; kk++){
			int tmpMax = dp[kk-1][0] - stockPrices[0] ;
			for (int i=1; i<stockPrices.length; i++){
				dp[kk][i] = Math.max( dp[kk][i-1], stockPrices[i] + tmpMax);
				tmpMax = Math.max(tmpMax,  dp[kk-1][i] - stockPrices[i]);
				maxProfit = Math.max( dp[kk][i], maxProfit );
			}
		}
		return maxProfit;
	}
	
	public static void main(String[] args){
		//int[] yesterday = new int[]{10, 7, 5, 8, 11, 9};
		int[] yesterday = new int[]{1,2,1,2};
		int maxProfit = StockPrice.getMaxProfit4(yesterday, 2);
		System.out.println("MaxProfit=" + maxProfit);
	}
}
