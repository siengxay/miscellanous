package com.snhien.algo.ctci;

public class MyStack <T>{
	Node<T> node;
	
	public MyStack(){
		node = null;
	}
	
	public MyStack(T data){
		node = new Node<T>(data);
	}
	
	public T pop(){
		if(node!=null){
			T top = node.getData();
			node = node.next;
			return top;
		}
		return null;
	}
	
	public T peek(){
		if(node!=null){
			return (node.getData());
		}
		return null;
	}
	
	public void push(T data){
		Node<T> newNode = new Node<T>(data);
		newNode.next = node;
		node = newNode;
	}

}
