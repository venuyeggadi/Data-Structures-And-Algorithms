import java.io.*;
import java.util.Scanner;
import static java.lang.Math.*;

public class NotShading {
	static Scanner in;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);// for online judge

		if (System.getProperty("ONLINE_JUDGE") == null) {
			try {
				System.setOut(new PrintStream(new FileOutputStream("output.txt")));
				in = new Scanner(new File("input.txt"));
			}
			catch (Exception e) {
			}
		}

		// Your Code Start Here
		int t = in.nextInt();

		while(t-- > 0) {
			System.out.println(solve());
		}

		in.close();
	}

	static int solve() {
		int m = in.nextInt(), n = in.nextInt();
		int r = in.nextInt()-1, c = in.nextInt()-1;
		char[][] arr = new char[m][n];

		for(int i = 0; i < m; i++)
			arr[i] = in.next().toCharArray();

		if(arr[r][c] == 'B')
			return 0;

		boolean sameRowOrColumn = false, anyRowOrColumn = false;
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(arr[i][j] == 'B') {
					if(i == r || j == c)
						sameRowOrColumn = true;
					anyRowOrColumn = true;
				}
			}
		}

		if(sameRowOrColumn)
			return 1;
		else if(anyRowOrColumn)
			return 2;

		return -1;
	}
}
