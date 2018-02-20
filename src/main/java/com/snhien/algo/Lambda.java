package com.snhien.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang.math.NumberUtils;

public class Lambda {

	public static List<Integer> sortNumbers(List<String> strings){
		//List<Integer> numbers = strings.stream().mapToInt( s-> NumberUtils.toInt(s) ).boxed().collect(Collectors.toList());
		List<Integer> numbers = strings.stream().mapToInt( s-> NumberUtils.toInt(s) ).sorted().boxed().collect(Collectors.toList());
		return numbers;
		
	}
	
	
	public static void main(String[] args) {
		
		List<String> input = Arrays.asList("1", "10", "2", "11", "3" );
		List<Integer> output = sortNumbers(input);
		System.out.println("output = " + output);
	}
}
