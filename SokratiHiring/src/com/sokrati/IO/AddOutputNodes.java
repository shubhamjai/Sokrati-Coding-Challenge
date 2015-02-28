package com.sokrati.IO;

import java.util.Map;
import java.util.Set;

import com.sokrati.Entity.TreeElement;
import com.sokrati.mappings.NameToNodeMapping;

/*
 * print output on console
 */
public class AddOutputNodes
{
	public static void addSetchild(Map<String,TreeElement> map, Set<String> set1, Set<String> set2, Set<String> subIntersection)
	{
		for(String name: set1)
		{
			TreeElement ne = NameToNodeMapping.getTreeElement(map, name);
			String parent = ne.getParent();
			if(set2.contains(parent))
			{
				subIntersection.add(name);
			}
		}
	}

}
