import java.io.*;
import java.util.Scanner;

public class NextRound {

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
		int n = in.nextInt();
		int k = in.nextInt();
		int[] scores = new int[n];

		for(int i = 0; i < n; i++)
			scores[i] = in.nextInt();

		int kth = scores[k-1];
		int count = 0;
		for(int score : scores) {
			if(score >= kth && score > 0)
				count++;
		}
		
		System.out.println(count);


		in.close();
	}
}
