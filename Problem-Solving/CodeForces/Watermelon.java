import java.io.*;
import java.util.Scanner;

public class Watermelon {

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
		// Read input
		int w = in.nextInt();

		if(w > 2 && ((w&1)==0))
			System.out.println("YES");
		else 
			System.out.println("NO");

		in.close();
	}
}