package com.snhien.algo;

public class LinkedList2 {
	Integer head;
	LinkedList2 tail;
	
	public LinkedList2(Integer head){
		this(head, null);
	}
	
	public LinkedList2(Integer head, LinkedList2 tail){
		this.head = head;
		this.tail = tail;
	}
	
	
	public int getHead(){
		return head;
	}
	public LinkedList2 getTail(){
		return tail;
	}
	public void setTail(LinkedList2 tail){
		this.tail = tail;
	}
	
	//Add element to the head of list
	public void push(Integer elt){
		LinkedList2 current = new LinkedList2(this.head, this.tail);
		this.head = elt;
		this.tail = current;
	}
	
	public Integer pop(){
		Integer res = this.head;
		if (this.tail==null){
			this.head = null;
		}
		else{
			this.head = this.tail.head;
			this.tail = this.tail.tail;
		}
		return(res);
	}
	
	public LinkedList2 reverse(){
		Integer currHead = this.head;
		LinkedList2 currTail = new LinkedList2(this.tail.head, this.tail.tail);
		LinkedList2 reverse = new LinkedList2(currHead);
		while(currHead!=null){
			currHead = currTail.pop();
			if (currHead!=null){
				reverse.push(currHead);
			}
		}
		return(reverse);
	}
	
	public String toString(){
		StringBuffer res = new StringBuffer();
		LinkedList2 tmp = new LinkedList2(this.head, this.tail);
		while (tmp!=null){
			Integer head = tmp.head;
			res.append( res.length()>0?"-"+head:head);
			tmp = tmp.tail;
		}
		return(res.toString());
		
	}
	
	public static void main(String args[]){
		LinkedList2 linkedList = new LinkedList2(3);
		linkedList.push(2);
		linkedList.push(8);
		linkedList.push(1);
		linkedList.push(9);
		linkedList.push(5);
		System.out.println("original=" + linkedList.toString());
		LinkedList2 reverse = linkedList.reverse();
		
		System.out.println("original=" + linkedList.toString() + " - reverse=" + reverse.toString() );
	}
	
	

}
