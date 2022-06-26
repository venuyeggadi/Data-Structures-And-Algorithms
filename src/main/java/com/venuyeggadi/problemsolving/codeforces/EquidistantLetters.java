package com.venuyeggadi.problemsolving.codeforces;

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class EquidistantLetters {
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
			int[] freq = new int[26];
			char[] word = in.next().toCharArray();
			Arrays.sort(word);
			System.out.println(new String(word));
		}


		in.close();
	}
}
