package com.venuyeggadi.problemsolving.codechef.longjune22;

import java.io.*;
import java.util.Scanner;
import static java.lang.Math.*;

class CHAIRS {
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
		int n = in.nextInt();

		for (int i = 0; i < n; i++) {
		    int a = in.nextInt();
			int b = in.nextInt();
			if (a > b)
				System.out.println(a - b);
			else
				System.out.println(0);
		}

		in.close();
		System.gc();
	}
}
