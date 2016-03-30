package com.snhien.algo.ctci;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SetOfStacks<T>{
	private List<Stack<T>> stackList;
	private int max;
	int size;
	
	public SetOfStacks(int max){
		stackList = new ArrayList<Stack<T>>();
		this.max = max;
		this.size = 0;
	}
	
	public void push(T data){
		if (stackList.size()==0){
			pushToNewStack(data);
		}
		else{
			Stack<T> stack = stackList.get(stackList.size()-1);
			if (size<max){
				stack.push(data);
				stackList.set(stackList.size()-1, stack);
				size++;
			}
			else{
				pushToNewStack(data);
			}
		}
	}
	
	protected void pushToNewStack(T data){
		Stack<T> stack = new Stack<T>();
		stack.push(data);
		stackList.add(stack);
		size = 1;
	}
	
	public T pop(){
		if (stackList.size() == 0 ){
			return null;
		}
		else{
			Stack<T> lastStack = stackList.get(stackList.size()-1);
			T data = lastStack.pop();
			if (lastStack.empty()){
				stackList.remove(stackList.size()-1);
				size = max;
			}
			else{
				size--;
			}
			return data;
		}
	}
	
	public T popAt(int stackIdx){
		if (stackIdx>=stackList.size()){
			return null;
		}
		Stack<T> stack = stackList.get(stackIdx);
		T data = stack.pop();
		for(int i=stackIdx; i<stackList.size()-1; i++){
			Stack<T> nextStack = stackList.get(i+1);
			T bottom = leftShift(nextStack);
			stack.push(bottom);
			stackList.set(i, stack);
			if (!nextStack.isEmpty()){
				stackList.set(i+1, nextStack);
			}
			else{
				size--;
			}
			stack = nextStack;
		}
		
		return data;
	}
	
	protected T leftShift(Stack<T> stack){
		T bottom = stack.elementAt(0);
		for(int i=0; i<stack.size()-1; i++){
			stack.set(i, stack.elementAt(i+1));
		}
		T top = stack.pop();
		return bottom;
	}
	
	public T peek(){
		if (stackList.size()==0){
			return null;
		}
		Stack<T> lastStack = stackList.get(stackList.size()-1);
		return lastStack.peek();
	}
	
	public String print(){
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for(Stack<T> stack: stackList){
			sb.append("{");
			StringBuilder sbInner = new StringBuilder();
			while(stack!=null && stack.peek()!=null){
				if (sbInner.length()>0){
					sbInner.append(",");
				}
				sbInner.append(stack.pop());
			}
			sb.append(sbInner);
			sb.append("}");
		}
		sb.append("}");
		return (sb.toString());
	}
	
	public static void main(String args[]){
		SetOfStacks<Integer> stacks = new SetOfStacks<Integer>(2);
		stacks.push(1);
		stacks.push(2);
		stacks.push(3);
		stacks.push(4);
		stacks.push(5);
		stacks.push(6);
		//System.out.println("stack = " + stacks.print());
		Integer pop1 = stacks.popAt(1);
		Integer pop2 = stacks.pop();
		System.out.println("pop1=" + pop1 + " pop2=" + pop2);
	}
}
