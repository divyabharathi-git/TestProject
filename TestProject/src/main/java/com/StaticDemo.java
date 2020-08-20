package com;

public class StaticDemo {
	
	static int id = 101;
	static int age = 23;
	static String college = "Prince";
	String school = "Jaigopal";

	void display() {
		System.out.println("id = " +id+" age ="+age+" college = "+college+" school ="+school);
	}
	 static void show() {
		//System.out.println("id = " +id+" age ="+age+" college = "+college+" school ="+school);
	}
	
	
	public StaticDemo(int id, int age, String school) {
		super();
		this.id = id;
		this.age = age;
		this.school = school;
	}



	public static void main(String[] args) {
		
		StaticDemo s = new StaticDemo(102,24,"violet");
		StaticDemo.college = "srm";
		id=105;
		age = 30;
		s.display();
		show();
		

	}

}
