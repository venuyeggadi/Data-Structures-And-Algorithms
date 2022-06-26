package com.venuyeggadi.problemsolving.basicprograms;

class CountingWords {
    public static void main(String[] args) {
        String s = "java is just awesome";
        //#1
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ' && s.charAt(i+1) != ' ')
                count++;
        }
        System.out.println(count);
    }
}