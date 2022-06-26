package com.venuyeggadi.problemsolving.basicprograms;

class CountingACharacter {
    public static void main(String[] args) {
        String s = "java is just awesome";
        //#1
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a')
                count++;
        }
        System.out.println(count);

        //#2
        String s1 = s.replace("a", "");
        System.out.println(s.length() - s1.length());
    }
}