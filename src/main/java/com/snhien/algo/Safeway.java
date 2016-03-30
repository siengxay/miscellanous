package com.snhien.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Safeway {
	
	/**
	 * Safeway coding exercise: Zip code range
	 * @author Siengxay Nhien
	 *
	 */
	
	
	/*
	 * A representation of number range where low<=high
	 */
	public static class Range{
		int low;
		int high;
		
		public Range(int low, int high){
			this.low = low;
			this.high = high;
		}
		
		public int getLow(){
			return low;
		}
		
		public int getHigh(){
			return high;
		}
		
		public String toString(){
			StringBuffer buffer = new StringBuffer();
			buffer.append("[").append(low).append("..").append(high).append("]");
			return (buffer.toString());
		}
	}
	
	/**
	 * Range comparator for ordering
	 */
	public static class RangeComparator implements Comparator<Range>{
		public int compare(Range r1, Range r2) {
			int res = 0;
			if (r2.getLow() < r1.getLow()){
				res = 1;
			}
			else if (r2.getLow() == r1.getLow()){
				if (r2.getHigh() < r1.getHigh()){
					res = 1;
				}
				else if (r2.getHigh() == r1.getHigh()){
					res = 0;
				}
				else res = -1;
			}
			else{
				res = -1;
			}
			return res;
		}
	}
	
	
	/**
	 * Given a collection ranges (each range includes both their upper and lower bounds), 
	 * return the minimum number of ranges required to represent the same restrictions as the input.
	 * @param ranges
	 * @return a list of ranges which may have been merged from input parameter
	 */
	
	public static List<Range> getMergedRanges(List<Range> listRanges){
		if (listRanges==null || listRanges.size()<2) return listRanges;
		List<Range> mergedRanges = new ArrayList<Range>();
		Range[] ranges = listRanges.toArray(new Range[0]);
		Arrays.sort(ranges, new RangeComparator());//order list before attempting to merge ranges
		for(int i=0; i<ranges.length; i++){
			Range range1 = ranges[i];
			if (i==ranges.length - 1){
				mergedRanges.add(range1);
				break;
			}
			Range range2 = ranges[i+1];
			boolean shouldMerge = shouldMerge (range1, range2);
			Range mergedRange = null;
			while (shouldMerge){
				mergedRange = 
						new Range(Math.min(range1.getLow(), range2.getLow()),
								  Math.max(range1.getHigh(), range2.getHigh()));
				range1 = mergedRange;
				if (i<ranges.length - 2){
					//Keep merging subsequent ranges
					range2 = ranges[++i + 1];
					shouldMerge = shouldMerge(range1, range2);
				}
				else if (i<ranges.length-1){
					//just merge with last range
					i++;
					shouldMerge = false;
				}
				else{
					//No merge needed, check next range
					shouldMerge = false;
				}
			}
			if (shouldMerge) {
				mergedRanges.add(mergedRange);
			}
			else{
				mergedRanges.add(range1);
			}
		}
		return mergedRanges;
	}
	

	/*Determine if 2 ranges should be merged (if the overlap, are adjacent, or nested)
	 * assuming they are already ordered (range1 < range2)
	 * e.g.: [1-4],[3-5] ===> true (overlap)
	 * 		 [1-2],[3-5] ===> true (adjacent)
	 * 		 [2,5],[3-4] ===> true (nested)
	 * 		 [1-2],[4-5] ===> false (disjoint)
	 * @param range1
	 * @param range2
	 */
	
	public static boolean shouldMerge(Range range1, Range range2){
		boolean res = false;
		if (range1.getHigh()+1>=range2.getLow() && range1.getLow()<=range2.getHigh()){
			res = true;
		}
		return res;
	}
	
	
	public static void main(String args[]){
		List<Range> zipCodes = new ArrayList<Range>();
		/*
		Range range1 = new Range(1,4); zipCodes.add(range1);
		Range range2 = new Range(2,5); zipCodes.add(range2);
		Range range4 = new Range(7,8); zipCodes.add(range4);
		Range range5 = new Range(9,10); zipCodes.add(range5);
		Range range3 = new Range(3,4); zipCodes.add(range3);//case with unordered list
		*/
		
		Range range1 = new Range(94133,94133); zipCodes.add(range1);
		Range range2 = new Range(94200,94299); zipCodes.add(range2);
		Range range3 = new Range(94226,94699); zipCodes.add(range3);
		List<Range> merged = getMergedRanges(zipCodes);
		System.out.println("Merged (" + merged.size() + ")=" + merged );
	}
}
