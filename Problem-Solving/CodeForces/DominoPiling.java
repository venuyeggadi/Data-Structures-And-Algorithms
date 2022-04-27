import java.io.*;
import java.util.Scanner;

public class DominoPiling {

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

		//Code Start Here
		int m = in.nextInt(), n = in.nextInt();

		/*
		int c1 = 0, c2 = 0;
		c1 = (m/2)*n + (m%2)*(n/2);
		c2 = (n/2)*m + (n%2)*(m/2);
		System.out.println(Math.max(c1, c2));
		*/
		
		/*
		System.out.println((m/2)*n + (m%2)*(n/2));
		*/

		System.out.println((m*n)/2);

		in.close();
	}
}