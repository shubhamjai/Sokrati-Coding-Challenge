package com.sokrati.IService;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import com.sokrati.Entity.TreeElement;
import com.sokrati.ImplService.SubTreeIntersectionImpl;

/*
 * API for storing tree data and computing sub-intersection 
 */
abstract public  class SubTreeIntersection
{
	/*
	 * return instance of SubTreeIntersection
	*/
	public static SubTreeIntersection getSubTreeIntersection()
	{
		return new SubTreeIntersectionImpl();
	}
	
	/*
	 *   create map from tree data
	*/
	abstract public Map<String,TreeElement> readTreeData() throws IOException;
	
	/*
	 * compute sub-intersection of the given input sets
	 */
	abstract public  Set<String> computeSubIntersection(Map<String,TreeElement> map) throws IOException;
}
