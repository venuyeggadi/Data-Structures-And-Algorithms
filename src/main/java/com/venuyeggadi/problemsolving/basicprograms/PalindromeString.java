package com.venuyeggadi.problemsolving.basicprograms;

class PalindromeString {
	public static void main(String[] args) {
		String str = "madam";
		
		//#1
		StringBuffer rev1 = new StringBuffer(str);
		System.out.println(rev1.reverse().toString().equals(str) ? "YES" : "NO");

		//#2
		char[] strArray = str.toCharArray();
		int start = 0, end = strArray.length - 1;
		while(start <= end) {
			if(strArray[start] != strArray[end])
				break;
			start++;
			end--;
		}
		System.out.println(start < end ? "NO" : "YES");
	}
}