package com.snhien.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClearSlide1 {

	private int begin;
	private int end;
	private List<Integer> listHours;
	
	public ClearSlide1(int begin, int end){
		if (end<=begin){
			//TODO
		}
		this.begin = begin;
		this.end = end;
		listHours = new ArrayList<Integer>();
		int count = 0;
		for (int i=begin; i<end; i++){
			listHours.add(count++, i);
		}
	}
	
	
	public static List<ClearSlide1> getCommon(List<ClearSlide1> users){
		List<ClearSlide1> common = new ArrayList<ClearSlide1>();
		int min = 23; int max = 0;
		
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();
		
		for(ClearSlide1 user: users){
			for(int i=user.begin; i<user.end; i++){
				Integer c = count.get(i);
				if (c!=null){
					count.put(i, ++c);
				}
				else{
					count.put(i, 1);
				}
			}
		}
		return(common);
	}
	
	public static void main(String args[]){
		
	}
}
