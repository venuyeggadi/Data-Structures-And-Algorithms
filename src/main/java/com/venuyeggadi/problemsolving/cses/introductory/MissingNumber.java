package com.venuyeggadi.problemsolving.cses.introductory;

import java.util.*;


//#1 Math
//O(n), O(1)
class MissingNumber1 {
	public static void main(String[] args) {		
		Scanner in = new Scanner(System.in);
		long n = in.nextInt();
		long sum = n * (n + 1)/2;
		
		for(int i = 1; i < n; i++)
		    sum = sum - in.nextInt();
		
		System.out.println(sum);
	}
}


//#2
//O(n), O(n)
class MissingNumber2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		boolean[] exist = new boolean[n + 1];

		for(int i = 0; i < n-1; i++) 
			exist[in.nextInt()] = true;

		for(int i = 1; i <= n; i++) {
			if(!exist[i]) {
				System.out.println(i);
				break;
			}
		}
	}
}


//#3 Bit Manipulation
//O(n), O(1) 
class MissingNumber3
{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int answer = 0;
		for(int i = 1; i < n; i++)
			answer = answer ^ i ^ in.nextInt();
		answer ^= n;
		System.out.println(answer);
	}
}


//#4 Brute Force
//O(n*log(n)), 
class MissingNumber4 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] num=new int[n-1];
		for (int i=0;i<n-1 ;i++ )
			num[i]=in.nextInt();
		Arrays.sort(num);
		if(num[0]!=1) {
			System.out.println(1);
			return;
		}
		for(int i=0;i<n-2;i++) {
			if(num[i+1]-num[i] != 1)
				System.out.println(num[i]+1);
		}
	}
}