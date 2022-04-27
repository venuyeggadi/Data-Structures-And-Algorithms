import java.io.*;
import java.util.Scanner;


public class BitPlusPlus {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);// for online judge

		if (System.getProperty("ONLINE_JUDGE") == null) {
			try {
				System.setOut(new PrintStream(new FileOutputStream("output.txt")));
				in = new Scanner(new File("input.txt"));
			}
			catch (Exception e) {
			}
		}

		// Your Code Start Here
		int N = in.nextInt();
		int value = 0;

		while(N-- > 0) {
			String op = in.next();
			if(op.charAt(0) == '+' || op.charAt(2) == '+')
				value++;
			else 
				value--;
		}

		System.out.println(value);


		in.close();
	}
}
