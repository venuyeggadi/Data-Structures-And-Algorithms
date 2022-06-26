package com.venuyeggadi.problemsolving.codechef.longjune22;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static java.lang.Math.*;

class DISTGCD {
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
            int diff = Math.abs(in.nextInt() - in.nextInt());
            int res = numberOfFactors(diff);
            System.out.println(res);
		}

		in.close();
		System.gc();
	}

    private static int numberOfFactors(int diff) {
        if (diff == 1)
            return 1;
        int res = 0;
        int k = 1;
        for (k = 1; k * k <= diff; k++)
            if (diff % k == 0)
                res++;
        k--;
        return k * k == diff ? 2*res -1 : 2 * res;
    }
}
