package com.venuyeggadi.problemsolving.basicprograms;

import java.util.Scanner;

class nCrCombination {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n and r : ");
        int n = in.nextInt(), r = in.nextInt();

        System.out.println(nCr(n, r));
    }

    static int nCr(int n, int r) {
        if(n-r < r)
            r = n - r;//C(N, r) = C(N, N-r); C = combination
        long numerator = 1, denominator = 1, gcd;
        for(int i = 1; i <= r; i++) {
            numerator *= (n-i+1);
            denominator *= i;
            gcd = gcd(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;
        }
        
        return (int)(numerator/denominator);
    }

    static long gcd(long a, long b) {
        if(a == 0)
            return b;
        return gcd(b%a, a);
    }
}