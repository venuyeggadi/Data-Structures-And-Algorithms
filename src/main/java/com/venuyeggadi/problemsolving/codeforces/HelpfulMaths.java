package com.venuyeggadi.problemsolving.codeforces;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.*;

public class HelpfulMaths {
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
        String[] strArr = in.nextLine().split("[+]");
        Arrays.sort(strArr);
        System.out.println(String.join("+", strArr));
		in.close();
		System.gc();
	}
}
