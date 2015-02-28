package com.sokrati.Util;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.sokrati.Entity.TreeElement;
import com.sokrati.IO.AddOutputNodes;
import com.sokrati.mappings.NameToNodeMapping;

/*
 * processing for the map
 */
public class NodeProcessor
{
	public static void processInput(Map<String,TreeElement> map, String nodes)
	{
		int length = nodes.length();
		while(true)
		{
			int start =nodes.indexOf("("); 
			if(start==-1) break;
			int end = nodes.indexOf(")");
			String str = fetchNodes(nodes, start, end);   // input string in range of start and end
			if(length>end)
			{
				nodes = nodes.substring(end+1, length);
				length = length - end-1;
			}
			if(null== str || str.equals("")) continue;
			int separatorIndex = str.indexOf(",");
			NameToNodeMapping.insertElement(map, str.substring(separatorIndex+1,str.length()).trim(), str.substring(0, separatorIndex).trim());
		}
	}
	
	/*
	 * fetch nodes from string where string in range [start,end]
	 */
	private static String fetchNodes(String node,int start, int end)
	{
		return node.substring(start+1, end);
	}
	
	/*
	 * insert nodeslist of set A into set "set"
	 */
	public static void insertSetANodeIntoSet(String nodesList, Set<String> setA)
	{
		insertNodeIntoSet(nodesList,setA);
	}
	
	/*
	 * insert nodeslist of set B into set "set"
	 */
	public static void insertSetBNodeIntoSet(String nodesList, Set<String> setB)
	{
		insertNodeIntoSet(nodesList,setB);
	}
	
	/*
	 * insert nodes from input data into set "set"
	 */
	private static void insertNodeIntoSet(String nodesList, Set<String> set)
	{
		String arr[]  = nodesList.split(",");
		for(String str: arr)
		{
			str = str.trim();
			set.add(str);
		}
	}

	/*
	 * print sub-intersection of two sets 
	 */
	public static Set<String> computeIntersection(Map<String,TreeElement> map, Set<String> set1, Set<String> set2)
	{
		Set<String> subIntersection = new HashSet<String>();
		AddOutputNodes.addSetchild(map,set1,set2, subIntersection);
		AddOutputNodes.addSetchild(map,set2,set1, subIntersection);
		return subIntersection;
	}
}
