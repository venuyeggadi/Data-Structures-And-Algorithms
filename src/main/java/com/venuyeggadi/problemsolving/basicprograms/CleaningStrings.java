package com.venuyeggadi.problemsolving.basicprograms;

class CleaningStrings {
    public static void main(String[] args) {
        //removing special characters
        String s = "!#$%&jsfdj&%&#$AHBKDF";
        String cleaned = s.replaceAll("[^a-zA-Z0-9]","");
        System.out.println(cleaned);

        //removing spaces
        String s1 = "Java is awesome.";
        s1 = s1.replace(" ", "");
        System.out.println(s1);
        //or
        s1 = "java is awesome.";
        s1 = s1.replaceAll("\\s", "");
        System.out.println(s1);
    }
}
