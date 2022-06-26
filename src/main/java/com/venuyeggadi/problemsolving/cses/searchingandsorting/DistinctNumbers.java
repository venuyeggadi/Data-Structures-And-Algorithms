//package com.venuyeggadi.problemsolving.cses.searchingandsorting;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static java.lang.Math.*;

class DistinctNumbers {
	static BufferedReader br;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));// for online judge

		if (System.getProperty("ONLINE_JUDGE") == null) {
			try {
				System.setOut(new PrintStream(new FileOutputStream("output.txt")));
				br = new BufferedReader(new FileReader("input.txt"));
			}
			catch (Exception e) {
			}
		}

		// Your Code Start Here
        br.readLine();
		String[] strArray = br.readLine().split(" ");
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(strArray));

        System.out.println(set.size());

		br.close();
		System.gc();
	}
}
