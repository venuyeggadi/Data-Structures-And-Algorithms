package com.venuyeggadi.algorithms;

import java.io.*;

class FastPower {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int a = Integer.parseInt(inputs[0]);
		int b = Integer.parseInt(inputs[1]);

		System.out.println(fastPowerIterative(a, b)); //pow(a, b);
		System.out.println(fastPowerRecursive(a, b));
		System.out.println(fastPower(a, b));
	}

	//O(log b), O(1)
	static int fastPowerIterative(int a, int b) {
		int result = 1;

		while(b > 0) {
			if((b&1) == 1)
				result = result * a;


			a = a * a;
			b = b >> 1;
		}

		return result;
	}

	//O(log b), O(log b)
	static int fastPowerRecursive(int a, int b) {
		if( b == 0)
			return 1;

		if((b&1) == 1)
			return a * fastPowerRecursive(a * a, b >> 1);

		return fastPowerRecursive(a * a, b >> 1);
	}

	//Divide and Conquer
	static int fastPower(int a, int b) {
		if(b == 0)
			return 1;
		if(b == 1)
			return a;
		return fastPower(a, b/2) * fastPower(a, (b+1)/2);
		/* To avoid writing special cases for b even and odd.
		   if b is even (b+1)/2 is same as b/2
		*/
	}
}

/*
  E.g. pow(5, 7) = 
       5*pow(5, 6) = 5*pow(25, 3) = 5*25*pow(25, 2) = 5*25*pow(625, 1) = 5*25*625*pow(625, 0)
       = 5 * 25 * 625
*/