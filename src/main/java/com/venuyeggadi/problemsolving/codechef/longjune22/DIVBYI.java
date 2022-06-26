package com.venuyeggadi.problemsolving.codechef.longjune22;

import java.io.*;
import java.util.Scanner;
import static java.lang.Math.*;

import java.io.*;
import java.util.Scanner;
import static java.lang.Math.*;

class DIVBYI {
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
            int left, right;
		    int N = in.nextInt();
            if ((N&1) == 1) {
                System.out.print(N/2 + 1);
                left = N/2; right = N/2 + 2;
            } else {
                System.out.print(N/2 + " " + (N/2 + 1));
                left = N/2 - 1; right = N/2 + 2;
            }
            while(left > 0) {
                System.out.print(" " + left + " " + right);
                left--;
                right++;
            }
            System.out.println();
		}

		in.close();
		System.gc();
	}
}
