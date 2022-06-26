package com.venuyeggadi.problemsolving.basicprograms;

import java.util.Random;

class RandomStrings {
    static Random rand = new Random();
    static String nextString(int length) {
        StringBuilder sb = new StringBuilder();
        int c;
        while(length-- > 0) {
            c = rand.nextInt(2)==0 ? (65+rand.nextInt(26)) : (97+rand.nextInt(26));
            sb.append((char)c);
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(nextString(10));
        System.out.println(nextString(34));
        System.out.println(nextString(2));
    }
}
