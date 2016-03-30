package com.snhien.algo.ctci;

public class BTreeNode {
	
	int data;
	BTreeNode left, right;

	public BTreeNode(int data){
		this.data = data;
	}
	
	public void setLeft(BTreeNode node){
		this.left = node;
	}
	
	public void setRight(BTreeNode node){
		this.right = node;
	}
	
	public void add(int data){
		if (data < this.data){
			if (left!=null){
				left.add(data);
			}
			else{
				left = new BTreeNode(data);
			}
		}
		else if (data>this.data){
			if (right!=null){
				right.add(data);
			}
			else{
				right = new BTreeNode(data);
			}
		}
		else{
			System.out.println("Element not added, already in the tree: " + data);
		}
	}
	
	public int getHeight(){
		int leftHeight = left==null? 0 : 1+left.getHeight();
		int rightHeight = right==null? 0 : 1+right.getHeight();
		int height = 1 + Math.max(leftHeight, rightHeight);
		return height;
	}
	
	public boolean isBalanced(){
		boolean balanced = false;
		int leftHeight = left==null ? 0: left.getHeight();
		int rightHeight = right==null? 0: right.getHeight();
		balanced = Math.abs(leftHeight - rightHeight) <= 1;
		return balanced;
	}
	
	public boolean isBST(){
		boolean res = (left!=null?left.data<this.data && left.isBST(null, this.data) :true) && 
					  (right!=null?this.data<right.data && right.isBST(this.data, null):true);
		return res;
	}

	
	protected boolean isBST(Integer min, Integer max){
		boolean res =  ((min!=null && this.data<=min) || 
						(max!=null && this.data>max));
		if (!res) return res;
		res = (left!=null?left.data<this.data && left.isBST(min, this.data) :true) && 
				(right!=null?this.data<right.data && right.isBST(this.data, max):true);
		return res;
	}
	
	public boolean equals(BTreeNode that){
		if (that==null){
			return false;
		}
		boolean dataEquals = ( this.data == that.data );
		if (!dataEquals){
			return false;
		}
		boolean leftEquals;
		if (this.left == null){
			if (that.left==null){
				 leftEquals = true;
			}
			else{
				leftEquals = false;
			}
		}
		else{
			leftEquals = this.left.equals(that.left);
		}
		if (!leftEquals){
			return false;
		}
		boolean rightEquals;
		if (this.right == null){
			if(that.right==null){
				rightEquals = true;
			}
			else{
				rightEquals = false;
			}
		}
		else{
			rightEquals = this.right.equals(that.right);
		}
		boolean res = dataEquals && leftEquals && rightEquals;
		return res;
	}
}
