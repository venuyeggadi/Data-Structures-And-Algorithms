import java.io.*;

class EuclidGCD {
   public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		long a = Long.parseLong(inputs[0]);
		long b = Long.parseLong(inputs[1]);

		System.out.println(gcd(a, b));
		System.out.println(iterativeGCD(a, b));
	}

	//O(log(min(a, b)))
	public static long gcd(long a, long b) {
		if(a == 0)
			return b;
		return gcd(b % a, a);

		//return a == 0 ? b; gcd(b % a, a);
	}

	//O(log(min(a, b))), O(1)
	public static long iterativeGCD(long a, long b) {
		long temp;
		while(a != 0) {
			temp = a;
			a = b % a;
			b = temp;
		}

		return b;
	}
}

/* Here a, b can be in any order since after one call the call however
   becomes gcd(m, n) where m < n;
*/

/*
Time Complexity :
1. Best Case : O(1)
   if y is divisible of x, then Euclid GCD terminates in one call.

2. Worst Case: O(log n)
   when x, y are two consecutive Fibonacci numbers
*/