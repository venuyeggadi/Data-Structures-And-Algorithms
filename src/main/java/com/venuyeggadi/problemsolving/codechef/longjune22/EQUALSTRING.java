package com.venuyeggadi.problemsolving.codechef.longjune22;

import java.io.*;
import java.util.Scanner;
import static java.lang.Math.*;

class EQUALSTRING {
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
        boolean[] f;
        for (int i = 0; i < n; i++) {
            f = new boolean[26];
            int N = in.nextInt();
            char[] a = in.next().toCharArray();
            char[] b = in.next().toCharArray();
            for (int k = 0; k < N; k++) {
                if (b[k] != a[k])
                    f[b[k]-'a'] = true;
            }
            int res = 0;
            for (int k = 0; k < 26; k++) {
                if (f[k])
                    res++;
            }
            System.out.println(res);
        }

		in.close();
	}
}
