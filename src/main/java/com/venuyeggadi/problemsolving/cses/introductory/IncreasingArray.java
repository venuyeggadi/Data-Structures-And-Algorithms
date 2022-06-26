package com.venuyeggadi.problemsolving.cses.introductory;

import java.util.Scanner;

//#1
class IncreasingArray1 {

	static final Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int n = in.nextInt();
		int[] a = new int[n];

		for(int i = 0; i < n; i++)
			a[i] = in.nextInt();

		long count = 0;
		for(int i = 1; i < n; i++) {
			if(a[i] < a[i-1]) {
				count += a[i-1] - a[i];
				a[i] = a[i-1];
			}
		}

		System.out.println(count);
	}
}


//#2
class IncreasingArray2 {

	static final Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int n = in.nextInt();

		long answer = 0, max = 0, x;
		for(int i = 0; i < n; i++) {
			x = in.nextInt();
			max = Math.max(max, x);
			answer += max - x;
		}

		System.out.println(answer);
	}
}
