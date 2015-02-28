package com.sokrati.mappings;

import java.util.Map;

import com.sokrati.Entity.TreeElement;

public class NameToNodeMapping
{
//	static private Map<String,TreeElement> map = new HashMap<String,TreeElement>();

	public static TreeElement getTreeElement(Map<String,TreeElement> map, String nodeName)
	{
		return map.get(nodeName);
	}
	
	private static void insertELement(Map<String,TreeElement> map, String nodeName, int level, String parent)
	{
		TreeElement treeObj= TreeElement.getInstance(level, parent);
		map.put(nodeName, treeObj);
	}
	
	public static void insertElement(Map<String,TreeElement> map, String childNode, String parentNode)
	{
		if(parentNode.equalsIgnoreCase("ROOT"))
		{
			insertParentNode(map, childNode);
			return;
		}
		insertChildNode(map, childNode, parentNode);
	}
	
	private static void insertParentNode(Map<String,TreeElement> map, String nodeName)
	{
		insertELement(map, nodeName, 1, nodeName);
	}
	
	private static void insertChildNode(Map<String,TreeElement> map, String nodeName, String parentNode)
	{
		int level = map.get(parentNode).getLevel();
		insertELement(map, nodeName,  level+1, parentNode);
	}
}
