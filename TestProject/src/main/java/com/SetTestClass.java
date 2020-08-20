package com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetTestClass {
	
	private Integer id;
	private String name;
	private Integer age;

	public SetTestClass(Integer id, String name, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	
	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SetTestClass other = (SetTestClass) obj;

		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}*/
	
	


	@Override
	public String toString() {
		return "SetTestClass [id=" + id + ", name=" + name + ", age=" + age + "]";
	}


	public static void main(String[] args) {
		
		Set<String> set = new HashSet<String>();
		set.add("One");
		set.add("Two");
		set.add("Three");
		set.add("One");
		
		System.out.println("normal set ==>" + set.size());
		
		Set<SetTestClass> setTest = new HashSet<SetTestClass>();
		
		setTest.add(new SetTestClass(101,"divya", 26));
		setTest.add(new SetTestClass(101,"divya", 26));
		
		System.out.println("object set ==>"+setTest.size());
		
		
		System.out.println(setTest);
		
		List<Integer> list= new ArrayList<Integer>();
		Object[] arr = list.toArray();
		
		
		
		
	}
	
}
