package com.venuyeggadi.problemsolving.basicprograms;

class FibonacciSeries {
	public static void main(String[] args) {
		int N = 10; //number of elements in series
		int n1 = 0, n2 = 1, sum;
		System.out.print(n1+" "+n2+" ");
		for(int i = 2; i < N; i++) {
			sum = n1 + n2;
			System.out.print(sum + " ");
			n1 = n2;
			n2 = sum;
		}
	}
}