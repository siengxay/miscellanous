package com.snhien.algo.ctci;

import java.util.*;

public class NTree {
	String key;
	Map<String, NTree> children;
	int count;
	
	public NTree getNTree(Iterator<LinkedHashMap<String, String>> iter){
		NTree root = new NTree();
		if (iter==null || iter.hasNext()==false){
			return null;
		}
		while (iter.hasNext()){
			NTree current = root;
			LinkedHashMap<String, String> json = iter.next();
			Iterator<String> iterKey = json.keySet().iterator();
			while (iterKey.hasNext()){
				String type = iterKey.next();
				String childKey = type + "_" + json.get(type);
				NTree child = current.children.get(childKey);
				if (child==null){
					child = new NTree(); 
					child.key  = childKey;
				}
				child.count++;
				current.children.put(childKey, child);
				current = child;
			}
		}
		return root;
	}
	
	
	public static void main(String args[]){
		List<LinkedHashMap<String, String>> logs = new ArrayList<LinkedHashMap<String, String>>();
		
	}
}
