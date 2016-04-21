package com.snhien.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Build a tree structure based on nodeId-parentId
public class ParentTree {
	
	public static class Item{
		int id;
		int weight;
		int parentId;
		
		public Item(int id, int weight, int parentId){
			this.id = id;
			this.weight = weight;
			this.parentId = parentId;
		}
	}
	
	Map<Integer, List<Integer>> parentChildMap; //parent itemId -> List<child itemId>
	Map<Integer, Item> items; //itemId -> item
	
	
	public ParentTree(){
		parentChildMap = new HashMap<Integer, List<Integer>>();
		items = new HashMap<Integer, Item>();
	}
	
	public void addItem(Item item){
		if (item!=null){
			if (!items.containsKey(item.id)){
				items.put(item.id, item);
				List<Integer> parentChildren = parentChildMap.get(item.parentId);
				if(parentChildren == null){
					parentChildren = new ArrayList<Integer>();
				}
				if (!parentChildren.contains(item.id)){
					parentChildren.add(item.id);
				}
				parentChildMap.put(item.parentId, parentChildren);
			}
		}
	}
	
	//get sum of weights for an item and its children
	public int getSumWeight(int itemId){
		if (!items.containsKey(itemId)){
			throw new IllegalArgumentException();
		}
		int sum = items.get(itemId).weight;
		if (parentChildMap.get(itemId)!=null){
			List<Integer> childrenIds = parentChildMap.get(itemId);
			for (Integer childId: childrenIds){
				sum += getSumWeight(childId);
			}
		}
		return sum;
	}
	/***
	 * 	NodeId	Weight	ParentID	sumWeight
	 * 	70		4		20				4
	 * 	60		3		40				3
	 * 	30		3		40				3
	 * 	40		6		20				12
	 * 	20		2		0				18
	 * 
	 * 			20
	 * 		40		70
	 * 	30		60
	 * 
	 * @param args
	 */
	public static void main(String args[]){
		ParentTree tree = new ParentTree();
		Item i70 = new Item(70, 4, 20); tree.addItem(i70);
		Item i60 = new Item(60, 3, 40); tree.addItem(i60);
		Item i30 = new Item(30, 3, 40); tree.addItem(i30);
		Item i40 = new Item(40, 6, 20); tree.addItem(i40);
		Item i20 = new Item(20, 2, 0); tree.addItem(i20);
		
//		System.out.println("sumWeight i70=" + tree.getSumWeight(70));
//		System.out.println("sumWeight i60=" + tree.getSumWeight(60));
//		System.out.println("sumWeight i30=" + tree.getSumWeight(30));
		System.out.println("sumWeight i40=" + tree.getSumWeight(40));
		System.out.println("sumWeight i20=" + tree.getSumWeight(20));
		
		
	}
}
