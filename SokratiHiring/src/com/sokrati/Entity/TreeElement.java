package com.sokrati.Entity;

/*
 * Tree node element
 * Store node meta data
 */

public class TreeElement
{
	int level;                // level of node in tree
	String parent;			  // parent of current node

	private TreeElement(int level, String parent)
	{
		this.level = level;
		this.parent = parent;
	}
	
	public String getParent() {
		return parent;
	}

	public int getLevel()
	{
		return level;
	}

	/*
	 * return istance of TreeElement
	 */
	public static TreeElement getInstance(int level, String parent)
	{
		return new TreeElement(level, parent);
	}
}
