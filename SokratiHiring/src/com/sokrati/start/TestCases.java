package com.sokrati.start;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.sokrati.Entity.TreeElement;
import com.sokrati.IService.SubTreeIntersection;

public class TestCases
{
	@Test
	public void testSubTreeIntersection() throws IOException
	{
		SubTreeIntersection subTree= SubTreeIntersection.getSubTreeIntersection();
		Map<String, TreeElement> map = subTree.readTreeData();
		Set<String>  output = subTree.computeSubIntersection(map);
		Set<String> set = new HashSet<String>();
		// Need to be updated as per current output
		set.add("Jayanagar");
		assertTrue(set.equals(output));
	}
	
	
}
