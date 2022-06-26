package com.venuyeggadi.problemsolving.codeforces;

import java.io.*;
import java.util.Scanner;

public class AncientCivilization {
	static Scanner in;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);// for online judge

		if (System.getProperty("ONLINE_JUDGE") == null) {
			try {
				System.setOut(new PrintStream(new FileOutputStream("output.txt")));
				in = new Scanner(new File("input.txt"));
			}
			catch (Exception e) {
			}
		}

		// Your Code Start Here
		int t = in.nextInt();

		while(t-- > 0) {
			int n = in.nextInt(), l = in.nextInt();
			int[] count = new int[l];

			for(int i = 0; i < n; i++) {
				int num = in.nextInt();
				for(int k = 0; k < l; k++)
					count[k] += (num>>k)&1;
			}
			
			int ans = 0;
			for(int i = 0; i < l; i++)
				if(count[i] > (n>>1))
					ans = ans | (1<<i);

			System.out.println(ans);
		}


		in.close();
	}
}