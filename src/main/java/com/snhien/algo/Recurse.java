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

    public static int jump(int[] nums) {
        if (nums == null){
            return -1;
        }
        return (jump(nums, 0));
        
    }
    
    protected static int jump(int[] nums, int index){
        if (nums.length==1){
            return 0;
        }
        int currMax = nums[index];
        if (currMax + index + 1 >= nums.length){
            return (1);
        }
        int[] options = new int[currMax];
        int min = 0;
        for (int i=1; i<=currMax; i++){
            options[i-1] = 1 + jump(nums, index + i);
            if(i==1){
            	min = options[i-1];
            }
            else if (options[i-1]<min){
                min = options[i-1];
            }
        }
        return min;
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
    	int[] a = new int[] {5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};// {6,2,6,1,7,9,3,5,3,7,2,8,9,4,7,7,2,2,8,4,6,6,1,3}; //{6,2,1,1,1,1,1,1,1,2}; 
    	int min = jump(a);
    	System.out.println("Min Nb of jumps = " + min);

    }

}
