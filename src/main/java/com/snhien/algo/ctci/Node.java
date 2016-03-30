package com.snhien.algo.ctci;

public class Node<T> {
	T data;
	Node<T> next;
	
	public Node(T data){
		this.data = data;
	}
	
	public T getData(){
		return data;
	}
	
	public Node<T> getNext(){
		return next;
	}
	
	public void add(T data){
		Node<T> newNode = new Node(data);
		Node n = this;
		while(n.next!=null){
			n = n.next;
		}
		n.next = newNode;
				
	}
	
	/*
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		if(data!=null){
			sb.append(data);
		}
		Node<T> n = this.next;
		while(n!=null){
			sb.append(",");
			sb.append(n.data);
		}
		sb.append("]");
		return sb.toString();
	}
	*/
}
