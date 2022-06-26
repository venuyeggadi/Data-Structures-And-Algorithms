package com.venuyeggadi.problemsolving.basicprograms;

class SwappingTwoNumbers {
	public static void main(String[] args) {
		int a = 10, b = 20;

		//#1
		int temp = a;
		a = b;
		b = temp;
		System.out.println(a+" "+b);

		a = 10;
		b = 20;
		//#2
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println(a+" "+b);

		a = 10;
		b = 20;
		//#3
		a = a * b;
		b = a / b;
		a = a / b;
		System.out.println(a+" "+b);

		a = 10;
		b = 20;
		//#4
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println(a+" "+b);

		a = 10;
		b = 20;
		//#5
		b = a + b - (a = b); //this shows that first all the values are bought into the expression and then evaluated.
		System.out.println(a+" "+b);

	}
}