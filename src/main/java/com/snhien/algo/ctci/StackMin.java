package com.snhien.algo.ctci;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackMin {
	Deque<Integer> nodes;
	Deque<Integer> nodeMin;
	
	public StackMin(Integer data){
		nodes = new ArrayDeque<Integer>();
		nodeMin = new ArrayDeque<Integer>();
		nodes.push(data);
		nodeMin.push(data);
	}
	
	public void push(Integer data){
		nodes.push(data);
		Integer currMin = getMin();
		if (data < currMin){
			nodeMin.push(data);
		}
		else{
			nodeMin.push(currMin);
		}
	}
	
	public Integer pop(){
		Integer res = nodes.pop();
		Integer min = nodeMin.pop();
		return(res);
	}
	
	public Integer getMin(){
		return (nodeMin.peek());
	}

	public static void main(String[] args){
		StackMin stackMin = new StackMin(4);
		stackMin.push(3);
		stackMin.push(2);
		stackMin.push(5);
		System.out.println("min=" + stackMin.getMin());
		Integer pop = stackMin.pop();
		System.out.println("pop=" + pop + " min=" + stackMin.getMin());
		pop = stackMin.pop();
		System.out.println("pop=" + pop + " min=" + stackMin.getMin());
	}
}
