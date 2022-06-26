package com.venuyeggadi.problemsolving.basicprograms;

class ReversingAString {
	public static void main(String[] args) {
		String str = "VenuY";
		
		//#1
		StringBuilder rev1 = new StringBuilder();
		for(int i = str.length() - 1; i >= 0; i--) {
			rev1.append(str.charAt(i));
		}
		System.out.println(rev1.toString());

		//#2
		StringBuffer rev2 = new StringBuffer();
		for(int i = str.length() - 1; i >= 0; i--) {
			rev2.append(str.charAt(i));
		}
		System.out.println(rev2.toString());

		//#3
		StringBuilder rev3 = new StringBuilder(str);
		System.out.println(rev3.reverse().toString());

		//#4
		StringBuffer rev4 = new StringBuffer(str);
		System.out.println(rev4.reverse().toString());

		//#5
		char[] strArray = str.toCharArray();
		int length = str.length();
		char temp;
		for(int i = 0; i < length/2; i++) {
			temp = strArray[i];
			strArray[i] = strArray[length - 1 - i];
			strArray[length - 1 - i] = temp;
		}
		System.out.println(new String(strArray));
	}
}