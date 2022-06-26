package com.venuyeggadi.problemsolving.basicprograms;

class BitManipulation {
    public static void main(String[] args) {
        int num = 4;

        //checking ith bit from right
        int i = 3;
        int mask = 1<<(i-1);  //(int)Math.pow(2, i-1)
        int result = num & mask;
        System.out.println(result); //non-zero indicates a bit '1' and zero indicates bit '0'

        //set ith bit
    }
}