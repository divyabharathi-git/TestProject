package com;

import java.io.IOException;

public final class Inheritance {
	
	public boolean flag;

	class Inner{
		void test() {
			if(Inheritance.this.flag) {
				sample();
			}
		}
	}

	public static void main(String[] args) {
		new Inheritance();

	}

	public void sample() {
		System.out.println("sample");
		
	}

}


