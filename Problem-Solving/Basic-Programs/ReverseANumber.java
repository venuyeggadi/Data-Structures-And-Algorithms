class ReverseANumber {
	public static void main(String[] args) {
		int num = 1234;
		int rev = 0;
		//#1
		while(num > 0) {
			rev = rev * 10 + num % 10;
			num = num / 10;
		}
		System.out.println(rev);

		num = 1234;
		rev = 0;
		//#2	
		rev = Integer.parseInt( new StringBuilder(String.valueOf(num)).reverse().toString() );
		System.out.println(rev);

		num = 1234;
		rev = 0;
		//#3
		rev = Integer.parseInt( new StringBuffer(String.valueOf(num)).reverse().toString() );
		System.out.println(rev);
	}
}