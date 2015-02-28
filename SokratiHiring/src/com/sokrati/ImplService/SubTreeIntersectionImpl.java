package com.sokrati.ImplService;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.sokrati.Entity.TreeElement;
import com.sokrati.IO.ReadInput;
import com.sokrati.IService.SubTreeIntersection;
import com.sokrati.Util.NodeProcessor;

public class SubTreeIntersectionImpl extends SubTreeIntersection
{
	/*
	 * create map from tree data
	 */
	@Override
	public Map<String,TreeElement> readTreeData() throws IOException
	{
		Map<String,TreeElement> map = new HashMap<String,TreeElement>();
		ReadInput.readInput(map);
		return map;
	}

	/*
	 * fill sets for input set A and set B 
	 */
	private void getInputSets(Map<String,TreeElement> map, Set<String> set1, Set<String> set2) throws IOException
	{
		ReadInput.readSubsets(map, set1, set2);
	}

	/*
	 * (non-Javadoc)
	 * @see com.sokrati.IService.SubTreeIntersection#computeIntersection(java.util.Map)
	 * compute sub-intersection of the given input sets
	 */
	@Override
	public Set<String> computeSubIntersection(Map<String,TreeElement> map) throws IOException
	{
		Set<String> set1 = new HashSet<String>();
		Set<String> set2 = new HashSet<String>();
		getInputSets(map, set1, set2);
		return NodeProcessor.computeIntersection(map, set1, set2);
	}
}
