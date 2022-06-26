package com.venuyeggadi.problemsolving.basicprograms;

class MaxOfThreeNumbers {
	public static void main(String[] args) {
		int a = 5, b = 12, c = 1;

		//#1
		if(a >= b && a >= c)
			System.out.println(a);
		else if(b >= a && b >= c)
			System.out.println(b);
		else
			System.out.println(c);

		System.out.println( c>(a>b?a:b)?c:(a>b?a:b) );
	}
}