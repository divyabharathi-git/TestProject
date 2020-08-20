package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FindingFirstDuplicate {
	
	public static void main(String[] args) {
		
		int arr[] = {10, 5, 3, 4, 3, 5, 6}; 
		System.out.println("length is =" + arr.length);
		
		int min = -1;
		
		/*HashSet<Integer> set = new HashSet<Integer>();
		
		for (int i=arr.length-1; i>=0; i--) 
        {
			if(set.contains(arr[i])) {
				min = i;
			}else {
				set.add(arr[i]);
			}
        }
		
		if(min != -1) {
			System.out.println("The repeating element is " +arr[min]);
		}else {
			System.out.println("there are no repeating elemnts");
		}*/
		
		List<Integer> list =  new ArrayList<Integer>();
		
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length-1;i++) {
				
				System.out.println();
				if(arr[i] == arr[j]) {
					list.add(arr[i]);
				}
				
			}
			
		}
		
		//System.out.println(list.get(0));
		
		
		
		
	}
	
	
	

}
