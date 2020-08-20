package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KSubSequences {

	public static void main(String[] args) {
		
		 int arr[] = {1,2,3,4,1};
		 int k = 3;
		 
		 Pairfunction(arr,k);
		 
	}
	
	static void Pairfunction(int[] arr,int k) {        
		
		int size = arr.length;
		
		// list is used to print the pairs
        Map<Integer, List<Integer>> hashMap = new HashMap<Integer, List<Integer>>();
        
        int currentSum = 0;
        for (int i = 0; i < size; i++) {
                currentSum += arr[i];
                
                System.out.println("current sum = "+currentSum);
                List<Integer> list = hashMap.get(currentSum % k);
                if (null != list) {
                        list.add(i);

                } else {
                        list = new ArrayList<Integer>();
                        list.add(i);
                }
                System.out.println("list = "+list);
                hashMap.put(currentSum % k, list);
        }
        
        int noOfSubArray = 0;
        for(Map.Entry<Integer, List<Integer>> entry : hashMap.entrySet()) {
                Integer key = entry.getKey();
                Integer listSize = entry.getValue().size();
                if(key == 0) {
                        noOfSubArray += (listSize*(listSize+1))/2;
                } else {
                        noOfSubArray += (listSize*(listSize-1))/2;
                }
        }
        
        System.out.println("No of subArray in O(k+n) time complexity "+noOfSubArray);
        


		
		
		
	}

}
