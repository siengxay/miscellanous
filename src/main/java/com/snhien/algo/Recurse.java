package com.snhien.algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Recurse {

public static LinkedList<Integer> sum(LinkedList<Integer> n1, LinkedList<Integer> n2){
    return (sum(n1, n2, 0));
}

protected static LinkedList<Integer> sum(LinkedList<Integer> n1, LinkedList<Integer> n2, Integer carryOver){
    if (n1==null || n1.size()==0){
        return(getStopCase(n2));
    }else if(n2==null || n2.size()==0){
        return(getStopCase(n1));
    }
    
    Integer head = n1.pop() + n2.pop() + carryOver;
    carryOver = (head>9)?1:0;
    head = (carryOver>0)? head - 10: head;
    LinkedList<Integer> res = sum(n1, n2, carryOver);
    res.addFirst(head);
    return (res);

}

public static List<List<Integer>> getMultipliers(int num){
	List<List<Integer>> res = new ArrayList<List<Integer>>();
	for (int i=2; i<num/2; i++){
		if (num % i == 0 ){
			int factor = num/i;
			List<List<Integer>> recurse= getMultipliers(factor);
			for(List<Integer> list: recurse){
				list.add(i);
				res.add(list);
			}
		}
	}
	List<Integer> self = new ArrayList<Integer>();
	self.add(num);
	res.add(self);
	return res;
}

protected static  LinkedList<Integer> getStopCase(LinkedList<Integer> n){
    if(n==null){
    	LinkedList<Integer> l0 = new LinkedList<Integer>();
    	l0.addFirst(0);
        return(l0);
    }
    else{
        return n;
    }
}

public static void main(String args[]){
	LinkedList<Integer> n1 = new LinkedList<Integer>();
		n1.addFirst(6);n1.addFirst(1);n1.addFirst(7);
	LinkedList<Integer> n2 = new LinkedList<Integer>();
		n2.addFirst(2);n2.addFirst(9);n2.addFirst(5);
	LinkedList<Integer> result = sum(n1, n2);	
	System.out.println("result " + result);
	
	List<List<Integer>> multipliers = getMultipliers(24);
	System.out.println("multipliers:" + multipliers);

}
}
