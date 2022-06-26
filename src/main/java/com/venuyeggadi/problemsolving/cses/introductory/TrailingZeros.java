package com.venuyeggadi.problemsolving.cses.introductory;

import java.io.*;
import java.util.Scanner;
import static java.lang.Math.*;

class TrailingZeros {
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
        System.out.println(solution());

		in.close();
		System.gc();
	}

    private static int solution() {
        int n = in.nextInt();
        int result = 0;
        while (n >= 5) {
            result += n/5;
            n /= 5;
        }
        return result;
    }
}
