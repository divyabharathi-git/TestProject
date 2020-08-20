package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrefixMatch {

	public static void main(String[] args) {
		
		String arr[] = {"aadr","bhk","aafgfg","lkk","jji"};
		
		List<String> list = new ArrayList<String>();
		
		list = Arrays.asList(arr);
		
		list = list.stream().filter(a->a.startsWith("aa")).collect(Collectors.toList());
		
		List<String> list1 = new ArrayList<String>();
		
		for(String s  : list) {
			long count = s.chars()
            .distinct()
            .count();
			
			list1.add(s+"-"+count);
			
		}
			
			
		System.out.println(list1);
		
		
		int intArr[] = {1,2,3,4,5};
		IntStream intstream = Arrays.stream(intArr);
		intstream.map(e->e+10).filter(e->e%2 == 0).forEach(e->System.out.println(e));
		
		String s1 = "";

		
	
		
		
	
		
	

	}

}
