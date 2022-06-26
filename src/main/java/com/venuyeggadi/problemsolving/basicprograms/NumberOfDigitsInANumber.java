package com.venuyeggadi.problemsolving.basicprograms;

import static java.lang.Math.*;

class NumberOfDigitsInANumber {
	public static void main(String[] args) {
		int num = 4;

		//#1
		int tempNum = num, count = 0;
		while(tempNum > 0) {
			tempNum = tempNum / 10;
			count++;
		}
		System.out.println(count);

		//#2 Same as above
		System.out.println((int)log10(num)+1);
		System.out.println( "digits in binary "+( (int)(log(num)/log(2)) + 1) ); //or (int)(log10(num)/log10(2)) + 1

		//#3
		System.out.println(String.valueOf(num).length());
	}
}