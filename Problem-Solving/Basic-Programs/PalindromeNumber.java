class PalindromeNumber {
	public static void main(String[] args) {
		int num = 1234321;
		int rev = 0;
		int tempNum = num;
		//#1
		while(tempNum > 0) {
			rev = rev * 10 + tempNum % 10;
			tempNum = tempNum / 10;
		}
		System.out.println(num == rev?"YES":"NO");
	}
}