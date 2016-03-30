package com.snhien.algo;

import java.util.*;

public class BetterProgrammerTask {
	
    public static int[] retainPositiveNumbers(int[] a) {
        /*
          Please implement this method to
          return a new array with only positive numbers from the given array.
          The elements in the resulting array shall be sorted in the ascending order.
         */
    	List<Integer> positiveNumbers = new ArrayList<Integer>();
    	int[] res = null;
    	for (int i=0; i<a.length; i++){
    		if (a[i]>=0){
    			positiveNumbers.add(a[i]);
    		}
    	}
    	res = new int[positiveNumbers.size()];
    	for (int j=0; j<positiveNumbers.size(); j++){
    		res[j] = positiveNumbers.get(j);
    	}
    	Arrays.sort(res);
    	return ( res );
    }
    
    public static boolean isPalindrome(String s) {
        /*
          Definition: A palindrome is a string that reads the same forward and backward.
          For example, "abcba" is a palindrome, "abab" is not.
          Please implement this method to
          return true if the parameter is a palindrome and false otherwise.
         */
    	boolean isPalindrome = false;
    	if (s!=null){
    		if (s.length()<2){
    			return true;
    		}
    		else{
    			for (int i=0; i<s.length()/2 ; i++){
    				if (s.charAt(i) == s.charAt(s.length()-i)){
    					isPalindrome = true;
    				}
    				else{
    					isPalindrome = false;
    					break;
    				}
    			}
    		}
    	}
    	return(isPalindrome);
    }



    public static int getSumOfTwoClosestToZeroElements(int[] a) {
        /*
          Please implement this method to
          return the sum of the two elements closest to zero.
          If there are two elements equally close to zero like -2 and 2,
          consider the positive element to be "closer" to zero than the negative one.
         */
    	if (a==null || a.length < 2){
    		throw new RuntimeException("Invalid array");
    	}
    	int sum, first, second;
    	if (Math.abs(a[0])<Math.abs(a[1])){
    		first = a[0];
    		second = a[1];
    	}
    	else{
    		first = a[1];
    		second = a[0];
    	}
    	
    	for (int i=1; i<a.length; i++){
    		if (Math.abs(a[i])<Math.abs(first)){
    			first = a[i];
    		}
    		else if (Math.abs(a[i]) == Math.abs(first)) {
    			first = Math.max(a[i], first);
    		}
    		else if (Math.abs(a[i])<Math.abs(second)){
    			second = a[i];
    		}
    		else if (Math.abs(a[i])==Math.abs(second)){
    			second = Math.max(a[i], second);
    		}
    	}
    	sum = first + second;
    	return(sum);
    }
    
    
    public static int getClosestToZero(int[] a) {
        /*
          Please implement this method to
          return the number in the array that is closest to zero.
          If there are two equally close to zero elements like 2 and -2
          - consider the positive element to be "closer" to zero.
         */
    	if(a==null || a.length==0){
    		throw new RuntimeException("Empty array");
    	}
    	int res = a[0];
    	for(int i=1; i<a.length; i++){
    		if (Math.abs(a[i]) < Math.abs(res)){
    			res = a[i];
    		}
    		else if (Math.abs(a[i]) == Math.abs(res)){
    			if (a[i]>0) {
    				res = a[i];
    			}
    		}
    	}
    	return res;
    }
    
    public static int countWords(String s) {
        /*
          Please implement this method to
          return the word count in a given String.
          Assume that the parameter String can only contain spaces and alphanumeric characters.
         */
    	int count = 0;
    	try{
    		String[] words = s.split(" ");
    		count = words.length;
    	}
    	catch(Exception e){
    		System.out.println("Exception countWords " + e.toString());
    	}
    	return(count);
    	
    }
    

    public static void sortIgnoringSpaces(String[] a) {
        /*
          Please implement this method to
          sort a given array of Strings in alphabetical order
          ignoring spaces (' ' symbols) within the strings.
         */
    	Map<String, String> map = new HashMap<String,String>();
    	String[] keys = new String[a.length];
    	for (int i=0; i<a.length; i++){
    		String noSpace = a[i].replaceAll(" ", "");
    		map.put(noSpace, a[i]);
    		keys[i] = noSpace;
    	}
    	Arrays.sort(keys);
    	for(int k=0; k<keys.length; k++){
    		a[k] = map.get(keys[k]);
    	}
    }
    
    // Please do not change this interface
    public static interface Node {
        int getValue();
        List<Node> getChildren();
    }
    
    public static class NodeImpl implements Node{
    	int value;
    	List<Node> children;
    	
    	public NodeImpl(){
    		
    	}
    	
    	public NodeImpl(int value){
    		this.value = value;
    		children = null;
    	}
    	public int getValue(){
    		return value;
    	}
    	
    	public void setValue(int value){
    		this.value = value;
    	}
    	
    	public List<Node> getChildren(){
    		return(children);
    	}
    	
    	public void setChildren(List<Node> children){
    		this.children = children;
    	}
    }

    public static List<Node> traverseTreeInWidth(Node root) {
        /*
          Please implement this method to
          traverse the tree in width and return a list of all passed nodes.

          The list should start with the root node, next
          it should contain all second-level nodes, then third-level nodes etc.

          The method shall work optimally with large trees.
         */
    	Queue<Node> queue = new ArrayDeque<Node>();
    	List<Node> res = new ArrayList<Node>() ;
    	queue.add(root);
    	while (!queue.isEmpty()){
    		Node node = queue.poll();
    		res.add(node);
    		if (node.getChildren()!=null){
    			queue.addAll(node.getChildren());
    		}
    	}
    	return(res);
    }


    public static double getAverage(Node root) {
    	double average = 0;
        /*
          Please implement this method to
          return the average of all node values (Node.getValue()) in the tree.
         */
    	int[] treeSum = getTreeSum(root);
    	average = (double)treeSum[0]/treeSum[1];
    	return (average);
    	
    }
    
    //Return a pair of numbers
    //-first one is sum of all nodes in tree
    //-second one is number of nodes in the tree 
    public static int[] getTreeSum(Node root){
    	int[] res = new int[2];
    	if (root==null){
    		res[0]=0;
    		res[1]=0;
    	}
    	else{
    		res[0] = root.getValue();
    		res[1] = 1;
    		if (root.getChildren()!=null){
	    		for(Node child: root.getChildren()){
	    			int[] childRes = getTreeSum(child);
	        		res[0] += childRes[0];
	        		res[1] += childRes[1]; 
	    		}
    		}
    	}
    	return(res);
    }
    
    
    public static List<Integer> getPerfectNumbers(int from, int to) {
        /*
          Please implement this method to
          return a list of all perect numbers in the given range inclusively.
          A perfect number is defined as a positive integer which is the sum of its positive divisors not including the number itself.
          For example: 6 is a perfect number because 6 = 1 + 2 + 3 (1, 2, 3 are divisors of 6)
          28 is also a perfect number: 28 = 1 + 2 + 4 + 7 + 14
         */
    	List<Integer> perfectNumbers = new ArrayList<Integer>();
    	for (int i=from; i<to; i++){
    		if (isPerfectNumber(i)){
    			perfectNumbers.add(i);
    		}
    	}
    	return(perfectNumbers);
    }
    
    protected static boolean isPerfectNumber(int n){
    	boolean res = false;
    	List<Integer> divisors = new ArrayList<Integer>();
    	for (int i=1; i<n; i++){
    		if (n % i == 0){
    			divisors.add(i);
    		}
    	}
    	int sumDivisors = 0;
    	for (int j=0; j<divisors.size(); j++){
    		sumDivisors+=divisors.get(j);
    	}
    	res = (sumDivisors==n);
    	return res;
    }


    public static int countWaysToJump(int N) {
        /*
          A set of stairs has N steps.
          You can jump either 1 or 2 steps at a time.
          For example, if the stairs is N=4 steps, you can reach the end in 5 possible ways:
          1-1-1-1, or 1-2-1 or 1-1-2 or 2-1-1 or 2-2
          Please implement this method to
          return the count of the different ways to reach the end of the stairs with N steps.
         */
    	int count = fibonacci(N+1);
    	return(count);
    }
   
    public static int fibonacci(int F){
    	if (F<=1){
    		return F;
    	}else {
    		return (fibonacci(F-1) + fibonacci(F-2));
    	}
    }
    
    public static void main(String args[]){
    	int[] array = new int[]{-1, 4, 2, -2, 5};
    	int sumTwoClosestToZero= getSumOfTwoClosestToZeroElements(array);
    	System.out.println("sumTwoClosestToZero=" + sumTwoClosestToZero);
    	int res = countWords("Hello World How are you");
    	System.out.println("res=" + res);
    	
    	String[] stringArray = new String[] {"Hello", "World", "How", "Are", "You"};
    	sortIgnoringSpaces(stringArray);
    	System.out.println(Arrays.toString(stringArray));

    	System.out.println("retainPositiveNumbers = " + Arrays.toString(retainPositiveNumbers(array)));
    	
    	List<Node> tree = new ArrayList<Node>();
    	//		1
    	//	2	3	4
    	//	5-6	-	7
    	//			8
    	
    	NodeImpl root = new NodeImpl(1);
    	Node n5 = new NodeImpl(5);
    	Node n6 = new NodeImpl(6);
    	NodeImpl n7 = new NodeImpl(7);
    	Node n8 = new NodeImpl(8);
    	NodeImpl n2 = new NodeImpl(2);
    	NodeImpl n3 = new NodeImpl(3);
    	NodeImpl n4 = new NodeImpl(4);
    	List<Node> l2 = new ArrayList<Node>();
    	l2.add(n5); l2.add(n6);
    	n2.setChildren(l2);
    	List<Node> l7 = new ArrayList<Node>();
    	l7.add(n8);
    	n7.setChildren(l7);
    	List<Node> l4 = new ArrayList<Node>();
    	l4.add(n7);
    	n4.setChildren(l4);
    	List<Node> l1 = new ArrayList<Node>();
    	l1.add(n2); l1.add(n3); l1.add(n4);
    	root.setChildren(l1);
    	
    	List<Node> bfs = traverseTreeInWidth(root);
    	for(Node n: bfs){
    		System.out.print( n.getValue() + " - " );
    	}
    	
    	System.out.println("Tree getAverage=" + getAverage(root));

    	
    	//List<Integer> perfectNumbers=getPerfectNumbers(1,30);
    	//System.out.println(perfectNumbers);
    	
    	int waysToJump = countWaysToJump(2);
    	System.out.println("waysToJump=" + waysToJump);
    	
    	int closestTo0 = getClosestToZero(array);
    	System.out.println("closestToZero=" + closestTo0);
    	
    }

}
