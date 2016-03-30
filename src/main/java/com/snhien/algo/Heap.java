package com.snhien.algo;

public class Heap {
	private int node;
	private Heap left;
	private Heap right;
	
	public Heap(){
	}
	
	public Heap(int n){
		this.node = n;
	}
	
	public int getNode() {
		return node;
	}
	public void setNode(int node) {
		this.node = node;
	}
	public Heap getLeft() {
		return left;
	}
	public void setLeft(Heap left) {
		this.left = left;
	}
	public Heap getRight() {
		return right;
	}
	public void setRight(Heap right) {
		this.right = right;
	}
	
	public void add(int n){
		if(n<this.node){
			if (left==null){
				left = new Heap();
			}
			else{
				left.add(n);
			}
		}
		else{
			
		}
	}
	
}
