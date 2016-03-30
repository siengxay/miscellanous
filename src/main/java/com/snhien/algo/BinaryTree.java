package com.snhien.algo;

public class BinaryTree {
	private int node;
	private BinaryTree left;
	private BinaryTree right;
	
	public void BinaryTree(int data){
		this.node = data;
	}

	public int getNode() {
		return node;
	}

	public void setNode(int node) {
		this.node = node;
	}

	public BinaryTree getLeft() {
		return left;
	}

	public void setLeft(BinaryTree left) {
		this.left = left;
	}

	public BinaryTree getRight() {
		return right;
	}

	public void setRight(BinaryTree right) {
		this.right = right;
	}

	public int getDepth(){
		if (getLeft()==null && getRight()==null){
			return 1;
		}
		else{
			int leftDepth = getLeft()==null ? 0: getLeft().getDepth();
			int rightDepth = getRight()==null ? 0: getRight().getDepth();
			int depth = Math.max(leftDepth, rightDepth);
			return(depth);
		}
	}
	
	public static int getDepth(BinaryTree bt){
		if (bt==null){
			return 0;
		}
		else{
			int leftDepth = getDepth(bt.getLeft());
			int rightDepth = getDepth(bt.getRight());
			int depth = 1 + Math.max(leftDepth, rightDepth);
			return(depth);
		}
	}
	
	public boolean isBalanced(){
		boolean isBalanced = false;
		int diffSize = getDepth(getLeft()) - getDepth(getRight());
		isBalanced = (Math.abs(diffSize) <= 1);
		return(isBalanced);
	}
}
