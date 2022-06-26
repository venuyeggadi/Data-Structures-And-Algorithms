package com.venuyeggadi.problemsolving.cses.introductory;

import java.util.Scanner;


//#1 Iterative
class WeirdAlgorithm {
	
	static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		long n = in.nextInt();
		
		System.out.print(n+" ");
		while(n > 1) {
			if((n&1) == 0)
				n = n/2;
			else 
				n = n*3 + 1;
			System.out.print(n+" ");
		}
	}

}

//#2 Recursive
class WeirdAlgorithmRecursive {
	static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = in.nextInt();
		printNums(n);
	}
	
	public static void printNums(long n) {
		if(n == 1) {
			System.out.println(n);
			return;
		}

		if( (n&1) == 0) {
			System.out.print(n+" ");
			printNums(n/2);
		}
		else {
			System.out.print(n+" ");
			printNums(n*3 + 1);
		}
	}

}