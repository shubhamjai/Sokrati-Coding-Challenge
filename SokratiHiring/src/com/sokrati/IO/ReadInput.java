package com.sokrati.IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import com.sokrati.Entity.TreeElement;
import com.sokrati.Util.NodeProcessor;

public class ReadInput
{
	private static String  fS = System.getProperty("file.separator");                     // file separator
	private static String path =  ".."+fS+"SokratiHiring"+fS+"src"+fS+"com"+fS+"sokrati"+fS+"input"+fS;
	public static void readInput(Map<String,TreeElement> map) throws IOException
	{	
		String fileName = path+"Input.txt";
		File f = new File(fileName).getCanonicalFile();         // input tree data
		FileReader fr = new FileReader(f);
		BufferedReader br  = new BufferedReader(fr);
		String input ;
		int start=-1;
		while((input = br.readLine())!=null)                   // read file
		{
			if(start==-1)
			{
				start = input.indexOf("{")+1;                    
				input = input.substring(start, input.length());

			}
			NodeProcessor.processInput(map,input);
		}
		
	}
	
	/*
	 * read sets (Set A and Set B) from input data
	 */
	public static void readSubsets(Map<String,TreeElement> map, Set<String> set1, Set<String> set2) throws IOException
	{
		String fileName = path +"Sets.txt";
		File f = new File(fileName).getCanonicalFile();        // input set file
		FileReader fr = new FileReader(f);
		BufferedReader br  = new BufferedReader(fr);
		String input ;
		int start=-1;
		boolean firstSet = false;

		while((input = br.readLine())!=null)
		{
			start = input.indexOf("{")+1;
			input = input.substring(start, input.indexOf("}"));

			if(firstSet==false)
			{
				firstSet = true;
				NodeProcessor.insertSetANodeIntoSet(input, set1);
			}
			else
			{
				NodeProcessor.insertSetBNodeIntoSet(input,set2);
			}
		}
	}
}