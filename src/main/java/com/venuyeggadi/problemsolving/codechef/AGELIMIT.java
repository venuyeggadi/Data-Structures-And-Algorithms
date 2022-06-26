package com.venuyeggadi.problemsolving.codechef;

import java.io.*;
import java.util.Scanner;

class AGELIMIT {
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
        int x, y, a;
        for (int i = 0; i < n; i++) {
            x = in.nextInt(); y = in.nextInt(); a = in.nextInt();
            System.out.println( a < y && a >= x ? "YES" : "NO");
        }


        in.close();
        System.gc();
    }
}
