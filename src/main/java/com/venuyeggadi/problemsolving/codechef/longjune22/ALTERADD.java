package com.venuyeggadi.problemsolving.codechef.longjune22;

import java.io.*;
import java.util.Scanner;
import static java.lang.Math.*;

class ALTERADD {
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
            if ((b-a) % 3 == 0 || (b-a+2) % 3 == 0)
                System.out.println("YES");
            else
                System.out.println("NO");
        }


		in.close();
	}
}
