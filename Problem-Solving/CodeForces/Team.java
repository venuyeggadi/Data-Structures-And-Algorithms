import java.io.*;
import java.util.Scanner;

public class Team {

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
		int count = 0;

		while(N-- > 0) {
			String op = in.nextL
			if(op[0]+op[1]+op[2] >= 2)
				count++;
		}

		System.out.println(count);


		in.close();
	}
}
