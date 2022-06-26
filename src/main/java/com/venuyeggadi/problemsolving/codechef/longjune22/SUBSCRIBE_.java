package com.venuyeggadi.problemsolving.codechef.longjune22;

import java.io.*;
import java.util.Scanner;
import static java.lang.Math.*;

class SUBSCRIBE_ {
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
        int N, X;
        for (int i = 0; i < n; i++) {
            N = in.nextInt();
            X = in.nextInt();
            System.out.println((int)ceil(N / 6.0) * X);
        }


		in.close();
	}
}