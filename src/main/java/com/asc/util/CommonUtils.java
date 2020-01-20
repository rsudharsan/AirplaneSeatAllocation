package com.asc.util;

import java.util.ArrayList;

public class CommonUtils {

	
	public static ArrayList<int[]>getArrayList(String input){
		
		ArrayList<int[]> arrList = new ArrayList<int[]>();
		String[] inputList = input.split("],");
		
		for(int i=0;i<inputList.length;i++) {
			String currString = inputList[i];
			int[] intarr = new int[2];
			char[] chars = currString.toCharArray();
			intarr[0]=Character.getNumericValue(chars[1]);
			intarr[1]=Character.getNumericValue(chars[3]);
			arrList.add(intarr);
			//System.out.println(intarr[0]+","+intarr[1]);
		}
		return arrList;
		
		
	}
}
