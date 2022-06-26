package com.venuyeggadi.problemsolving.codeforces;

import java.io.*;
import java.util.Scanner;

public class WayTooLongWords {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);// for online judge

		if (System.getProperty("ONLINE_JUDGE") == null) {
			try {
				System.setOut(new PrintStream(new FileOutputStream("output.txt")));
				in = new Scanner(new File("input.txt"));
			}
			catch (Exception e) {
			}
		}

		// Your Code Start Here
		int N = in.nextInt();

		while(N-- > 0) {
			String word = in.next();
			int length = word.length();
			if(length > 10)
				System.out.println(word.charAt(0)+String.valueOf(length-2)+word.charAt(length-1));
			else
				System.out.println(word);
		}


		in.close();
	}
}