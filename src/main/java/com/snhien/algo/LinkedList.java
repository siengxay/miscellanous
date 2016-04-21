package com.snhien.algo;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {
	
	LinkedList next = null;
	int data;
	
	public LinkedList(Integer ...elements){
		//LinkedList toAdd = new LinkedList();
		if (elements.length>0){
			LinkedList tail = null;
			this.data = elements[0];
			for (int i=elements.length-1; i>0; i--){
				LinkedList node = new LinkedList();
				node.data = elements[i];
				node.next = tail;
				tail = node;
			}
			this.next = tail;
		}
	}
	
	public LinkedList(Integer data, LinkedList next){
		this.data = data;
		this.next = next;
	}
	
	public LinkedList getNext(){
		return this.next;
	}
	
	public int getData(){
		return (this.data);
	}
	
	public void setNext(LinkedList next) {
		this.next = next;
	}

	public void setData(int data) {
		this.data = data;
	}

	/**
	 * Add an element to the tail of the list
	 * @param data
	 */
	public void addTail(int data){
		LinkedList newNode = new LinkedList(new Integer[]{data});
		LinkedList current = this;
		while (current.next!=null){
			current = current.next;
		}
		current.next = newNode;
	}
	
	public void addTail(LinkedList list){
		LinkedList current = this;
		while(current.next!=null){
			current = current.next;
		}
		current.next = list;
	}
	
	//NOT WORKING
	public void push(int data){
		LinkedList tmp = new LinkedList(this.data, this.getNext());
		setData(data);
		setNext(tmp);
	}
	
	public void push(LinkedList list){
		if (list==null) return;
		LinkedList current = list;
		while (current.next!=null){
			current = current.next;
		}
		current.next = this;
		this.data = list.data;
		this.next = list.next;
	}
	
	public void removeDuplicates(){
		Set<Integer> dataSet = new HashSet<Integer>();
		dataSet.add(this.data);
		this.next = removeDuplicates(this.next, dataSet);
	}
	
	protected static LinkedList removeDuplicates(LinkedList list, Set<Integer> dataSet){
		if (list==null){
			return null;
		}
		else{
			if (dataSet.contains(list.data)){
				return ( removeDuplicates(list.next, dataSet));
			}
			else{
				dataSet.add(list.data);
				list.next = removeDuplicates(list.next, dataSet);
				return (list);
			}
		}
	}
	
	public int getKthToLast(int k){
		int p1 = 0;
		int p2 = k;
		LinkedList l1 = this;
		LinkedList l2 = this;
		for (int i=0; i<=p2; i++){
			l2 = l2.next;
		}
		while (l2!=null){
			l1 = l1.next;
			l2 = l2.next;
		}
		return (l1.data);
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("[").append(this.data);
		LinkedList next = this.next;
		while (next!=null){
			sb.append(",").append(next.data);
			next = next.next;
		}
		sb.append("]");
		return (sb.toString());
	}
	
	public static LinkedList deleteNode(LinkedList list){
		LinkedList next = list.next;
		return(next);
	}
	
	public static void partition(LinkedList list, int data){
		LinkedList less = null;
		LinkedList more = new LinkedList(data);
		LinkedList current = list;
		while (current!=null){
			if (current.data<data){
				if (less==null){
					less = new LinkedList(current.data);
				}
				else {
					less.addTail(current.data);
				}
			}
			else if (current.data>data){
				more.addTail(current.data);
			}
			current = current.next;
		}
		less.addTail(more);;
		list.data = less.data;
		list.next = less.next;
		
	}
	
	public static class NumberList extends LinkedList{
		/*
		public Double getValue(){
			Double value = 0.0;
			int n=0;
			LinkedList current = this;
			while(current!=null){
				value = this.data * Math.pow(10, n);
				n++;
				current = current.next;
				
			}
			return value;
		}
		*/
		
		public static NumberList sum(NumberList n1, NumberList n2){
			NumberList result = new NumberList();
			NumberList c1 = n1, c2=n2;
			int carryOver = 0;
			int exp = 0;
			while(c1!=null){
				Integer currentVal =  c1.data + c2.data + carryOver;
				if (currentVal>=10){
					currentVal = currentVal - 10;
					carryOver = 1;
				}
				else{
					
					carryOver = 0;
				}
				result.setData(currentVal);
				//result.setNext(next);
				//c1 = c1.next;
				
			}
			return(result);
		}
		
		
	}
	
	
	public static LinkedList reverse(LinkedList list){
		if (list==null || list.next==null){
			return list;
		}
		LinkedList rev = new LinkedList();
		LinkedList curr = list;
		while (curr!=null){
			rev.push(curr.getData());
			curr = curr.getNext();
		}
		return (rev);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList(1,2,3,2,4,5,5);
		System.out.println("Original list=" + list.toString());
//		list.removeDuplicates();
//		System.out.println("RemoveDuplicates=" + list.toString());
		int kthToLast = list.getKthToLast(2);
		System.out.println("KthToLast = " + kthToLast);
		
		LinkedList delete = deleteNode(list);
		System.out.println("delete = " + delete.toString());
		
		partition(list, 3);
		System.out.println("partition=" + list);
		
		LinkedList reverse = reverse(list);
		System.out.println("reverse=" + reverse.toString());

	}


}


