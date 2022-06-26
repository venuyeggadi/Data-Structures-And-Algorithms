package com.venuyeggadi.problemsolving.basicprograms;

class ReverseEachWord {
    public static void main(String[] args) {
        String str = "java is just awesome";
        String[] strArray = str.split("\\s");
        StringBuilder sb = new StringBuilder();
        sb.append(new StringBuilder(strArray[0]).reverse());
        for(int i = 1; i < strArray.length; i++) {
            sb.append(" "+new StringBuilder(strArray[i]).reverse());
        }
        System.out.println(sb.toString());
    }
}