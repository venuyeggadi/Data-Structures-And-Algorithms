package com.venuyeggadi.problemsolving.basicprograms;

public class DecimalToBinaryConversion {
    public static void main(String[] args) {
        int num = 127;
        System.out.println(toBinary(num));
        System.out.println(Integer.toBinaryString(num));
    }

    private static String toBinary(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 1) {
            int bit = num % 2;
            num = num / 2;
            sb.append(bit);
        }
        sb.append(num);

        return sb.reverse().toString();
    }
}
