package com.snhien.algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class BinaryTree {
	private int node;
	private BinaryTree left;
	private BinaryTree right;
	
	public BinaryTree(int data){
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
	
	public List<Integer> getBFS() {
		List<Integer> bfs = new ArrayList<Integer>();
		Queue<BinaryTree> q = new java.util.LinkedList<BinaryTree>();
		BinaryTree t1 = this;
		q.add(t1);
		while (!q.isEmpty()) {
			BinaryTree current = q.poll();
			bfs.add(current.node);
			if (current.left!=null) q.add(current.left);
			if (current.right!=null) q.add(current.right);
		}
		return bfs;
	}
	
	public List<Integer> getDFS(){
		List<Integer> dfs = new ArrayList<Integer>();
		Stack<BinaryTree> s = new Stack<BinaryTree>();
		BinaryTree t = this;
		Set<BinaryTree> visited = new HashSet<BinaryTree>();
		s.add(t);
		visited.add(t);
		while (!s.isEmpty()) {
			BinaryTree current = s.peek();
			if (current.left!=null && !visited.contains(current.left)) {
				s.push(current.left);
				visited.add(current.left);
			}
			else if (current.right!=null && !visited.contains(current.right)) {
				s.push(current.right);
				visited.add(current.right);
			}
			else {
				current = s.pop();
				dfs.add(current.node);
			}
			
		}
		return dfs;
	}
	
	public static void main(String args[]) {
		BinaryTree bt = new BinaryTree(4);
		BinaryTree l1 = new BinaryTree(2);
		BinaryTree l2 = new BinaryTree(3);
		l1.setRight(l2);
		bt.setLeft(l1);
		BinaryTree r1 = new BinaryTree(6);
		BinaryTree r21 = new BinaryTree(5);
		BinaryTree r22 = new BinaryTree(7);
		BinaryTree r3 = new BinaryTree(8);
		r22.setRight(r3);
		r1.setLeft(r21);
		r1.setRight(r22);
		bt.setRight(r1);
		List<Integer> bfs = bt.getBFS();
		System.out.print("\n**** BFS: ");
		for (Integer i: bfs) {
			System.out.print(i + " " );
		}

		List<Integer> dfs = bt.getDFS();
		System.out.print("\n**** DFS: ");
		for (Integer i: dfs) {
			System.out.print(i + " " );
		}

	
	}
	
}
