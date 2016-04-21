package com.snhien.algo;

public class IntervalTree implements Comparable<IntervalTree>{
	int low;
	int high;
	int maxHigh;
	IntervalTree left;
	IntervalTree right;
	
	public IntervalTree(int low, int high){
		this.low = low;
		this.high = high;
		this.maxHigh = high;
	}
	
	public void addInterval(IntervalTree tree){
		if (tree.low < this.low){
			if (this.left == null){
				this.left = tree;
				this.maxHigh = Math.max(this.maxHigh, this.left.maxHigh);
			}
			else {
				this.left.addInterval(tree);
				this.maxHigh = Math.max(this.maxHigh, this.left.maxHigh);
			}
		}
		else if (tree.low > this.low){
			if (this.right == null){
				this.right = tree;
				
			}
			else{
				this.right.addInterval(tree);
			}
			this.maxHigh = Math.max(this.maxHigh, this.right.maxHigh);
		}
		else{
			//this.low == tree.low
			if (this.high < tree.high){
				this.low = tree.low;
				this.high = tree.high;
				this.maxHigh = Math.max(tree.maxHigh, this.maxHigh);
			}
		}
	}

	public int compareTo(IntervalTree tree) {
		// TODO Auto-generated method stub
		if (this.low<tree.low){
			return -1;
		}
		else if (this.low > tree.low){
			return 1;
		}
		//(this.low == tree.low
		else if (this.high < tree.high){
			return -1;
		}
		else if (this.high > tree.high){
			return 1;
		}
		else {
			return 0;
		}
	}
	
	
	public IntervalTree getIntersection(IntervalTree tree){
		if (tree.low < this.low){
			if (this.left == null){
				if (tree.high<this.low){
					return null;
				}
				else return new IntervalTree(this.low, Math.min(this.high, tree.high));
			}
			else {
				return (this.left.getIntersection(tree));
			}
		}
		else if (tree.low > this.low ){
			if (this.right == null){
				if (tree.low > this.high){
					return null;
				}
				else return new IntervalTree(tree.low, Math.min(this.high, tree.high));
			}
			else{
				return (this.right.getIntersection(tree));
			}
		}
		else{
			return new IntervalTree(this.low, Math.min(this.high, tree.high));
		}
	}
	 
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("[").append(this.low);
		sb.append("-").append(this.high);
		if (this.high!=this.maxHigh){
			sb.append("(").append(this.maxHigh).append(")");
		}
		sb.append("]");
		return sb.toString();
	}
	
	public static void main(String args[]){
		IntervalTree root = new IntervalTree(10, 14);
		root.addInterval(new IntervalTree(9, 12));
		root.addInterval(new IntervalTree(11, 15));
		
		IntervalTree intersect = root.getIntersection(new IntervalTree(10, 12));
		System.out.println("root=" + root + " Intersect = " + intersect );
	}
}
