package com.venuyeggadi.problemsolving.basicprograms;

public class NumberOfFactorsOfANumber {
    public static void main(String[] args) {
        System.out.println(numberOfFactors(20));
    }

    public static int numberOfFactors(int diff) {
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
