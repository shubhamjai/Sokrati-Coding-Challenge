package com.sokrati.start;

import java.io.IOException;
import java.util.Map;

import com.sokrati.Entity.TreeElement;
import com.sokrati.IService.SubTreeIntersection;

/*
 * Run this file to start program
 */
public class Start
{
	public static void main(String[] args) throws IOException
	{
		SubTreeIntersection subTree= SubTreeIntersection.getSubTreeIntersection();
		Map<String, TreeElement> map = subTree.readTreeData();
		System.out.println(subTree.computeSubIntersection(map));
	}
}
