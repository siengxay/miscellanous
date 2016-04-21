package com.snhien.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.snhien.algo.Inheritance.A;

public class ArraysQuiz {
/*
	public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
	    int m = a.size();
	    int n = a.get(0).size();
	    for(int i=0; i<m; i++){
	        for (int j=0; j<n; j++){
	            if (a.get(i).get(j) == 0){
	                markZeroes(a,m, n, i, j);
	            }
	        }
	    }
	    for(int i=0; i<m; i++){
	        for (int j=0; j<n; j++){
	            if (a.get(i).get(j)==2){
	                a.get(i).set(j, 0);
	            }
	        }
	    }
	}
	
	protected static void markZeroes(ArrayList<ArrayList<Integer>>a, int m, int n, int i, int j){
	    for(int x=0; x<m; x++){
	    	if (a.get(x).get(j)!=0){
	    		a.get(x).set(j,2);
	    	}
	    }
	    for(int y=0; y<n; y++){
	    	if (a.get(i).get(y)!=0){
	    		a.get(i).set(y, 2);
	    	}
	    }
	}
*/
	
	public static void setZeroes(ArrayList<ArrayList<Integer>> a){
		int nRows = a.size();
		int nCols = a.get(0).size();
		
		boolean[] markRows = new boolean[nRows];
		boolean[] markCols = new boolean[nCols];
		
		for (int i=0; i<nRows; i++){
			for(int j=0; j<nCols; j++){
				if(a.get(i).get(j)==0){
					markRows[i]=true;
					markCols[j]=true;
				}
			}
		}
		
		for(int i=0; i<nRows; i++){
			if (markRows[i]){
				for(int j=0; j<nCols; j++){
					a.get(i).set(j, 0);
				}
			}
		}
		
		for(int j=0; j<nCols; j++){
			if (markCols[j]){
				for (int i=0; i<nRows; i++){
					a.get(i).set(j,0);
				}
			}
		}
 	}
	
	public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		int size = 2*a - 1;
		int[][] tmp = new int[size][size];
		for(int i=0; i<a; i++){
			for (int j=0; j<a; j++){
				int max = Math.max(i, j);
				tmp[a + i -1 ][ a + j -1] = 1 + max;
				tmp[a - i -1 ][ a + j -1] = 1 + max;
				tmp[a - i -1 ][ a - j -1] = 1 + max;
				tmp[a + i -1 ][ a - j -1] = 1 + max;	
			}
		}
		for(int i=0; i<size; i++){
			ArrayList<Integer> row = new ArrayList<Integer>();
			for (int j=0; j<size; j++){
				row.add(tmp[i][j]);
			}
			res.add(row);
		}
		return res;
	}

	
	public ArrayList<ArrayList<Integer>> prettyPrint2(int a) {
		int size = 2*a - 1;
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>(size);
		for (int i=0; i<size; i++){
			ArrayList<Integer> row = new ArrayList<Integer>();
			for (int j=0; j<size; j++){
				row.add(0);
			}
			res.add(row);
		}
		
		for(int i=0; i<a; i++){
			for (int j=0; j<a; j++){
				int max = Math.max(i, j);
				res.get(a+i-1).set(a+j-1, 1+max);
				res.get(a-i-1).set(a+j-1, 1+max);
				res.get(a-i-1).set(a-j-1, 1+max);
				res.get(a+i-1).set(a-j-1, 1+max);
			}
		}
		return res;
	}

	
	public static List<Integer> getIntersections(int[] a1, int[] a2){
		List<Integer> inter = new ArrayList<Integer>();
		int i=0, j=0;
		while (i<a1.length && j<a2.length){
				if (a1[i]==a2[j]){
					inter.add(a1[i]);
					i=i+1;
					j=j+1;
				}
				else if (a1[i]<a2[j]){
					i = i + 1;
				}
				else{ //a1[i]>a2[j]
					j = j + 1;
				}
		}
		return (inter);
	}
	
	public static void printList(List<List> list){
		for (List rows: list){
			System.out.print("[ ");
			for(Object i: rows){
				System.out.print(i + " ");
			}
			System.out.println(" ]");
		}
	}
	
	
	public static int removeDuplicates(ArrayList<Integer> a) {
		/*
		if (a==null){
			return -1;
		}
		if (a.size()==0){
			return 0;
		}
		int l;
		int curr = a.get(0);
		for(int i=1; i< a.size() ; ){
			int next = a.get(i);
			if (curr == next){
				int dup = a.remove(i);
			}
			else{
				curr = next;
				i++;
			}
		}
		l = a.size();
		return(l);
		*/
	    int index = 1;
	    int n = a.size();
	    
	    if (a == null || a.size() == 0)
	        return 0;
	    
	    for (int i = 1; i < n; i++) {
	        
	        if (a.get(i).intValue() != a.get(i - 1).intValue()) {
	            int temp = a.get(index);
	            a.set(index, a.get(i));
	            index++;
	        }
	    }
	    return index;
	}
	
	public static void main(String args[]){
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(0); b.add(0);
		ArrayList<Integer> c = new ArrayList<Integer>();
		c.add(1); c.add(1);
		a.add(b);
		a.add(c);
		setZeroes(a);
		/*
		for (ArrayList<Integer> rows: a){
			System.out.print("[ ");
			for(Integer i: rows){
				System.out.print(i + " ");
			}
			System.out.println(" ]");
		}*/
		
		ArraysQuiz quiz = new ArraysQuiz();
		ArrayList<ArrayList<Integer>> pretty = quiz.prettyPrint2(4);
		
		for (ArrayList<Integer> rows: pretty){
			System.out.print("[ ");
			for(Integer i: rows){
				System.out.print(i + " ");
			}
			System.out.println(" ]");
		}
		
		
		List<Integer> inter = getIntersections(new int[]{1000}, new int[]{1000});
		System.out.print("intersections " + inter);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0); list.add(0); list.add(0);list.add(2);list.add(2);list.add(3);list.add(4);list.add(4);
		System.out.println("duplicates = " + removeDuplicates(list));
		
	}
}
