package com.venuyeggadi.problemsolving.cses.introductory;

import java.util.Scanner;

//All the approaches are same.

//#1
class Repititions1 {

	static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		char[] strArr = in.next().toCharArray();

		int count = 1, max = 1;
		for(int i = 1; i < strArr.length; i++) {
			if(strArr[i] == strArr[i-1]) {
				count++;
				max = Math.max(count, max);
			}
			else
				count = 1;
		}

		System.out.println(max);
	}

}


//#2
class Repititions2 {
	
	static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {

		char[] strArr = in.next().toCharArray();

		int count = 1, max = 1;
		for(int i = 1; i < strArr.length; i++) {
			if(strArr[i] == strArr[i-1])
				count++;
			else {
				max = Math.max(count, max);
				count = 1;
			}
		}

		max = Math.max(count, max);//in case the common sequece is at the end of the string.
		System.out.println(max);
	}

}


//#3
class Repitition3 {
	static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		char[] strArr = in.next().toCharArray();

		int count = 1, max = 1;
		for(int i = 1; i < strArr.length; i++) {
			if(strArr[i] == strArr[i-1])
				count++;
			else
				count = 1;
			
			max = Math.max(count, max);
		}

		System.out.println(max);
	}

}