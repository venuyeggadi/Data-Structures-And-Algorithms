import java.io.*;
import java.util.Scanner;
import static java.lang.Math.*;

public class BeautifulMatrix {

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
		int[][] mat = new int[5][5];

		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 5; j++)
				mat[i][j] = in.nextInt();

		int m = 0, n = 0;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++){
				if(mat[i][j] == 1){
					m = i+1;
					n = j+1;
					break;
				}
			}
		}

		System.out.println(abs(m-3)+abs(n-3));


		in.close();
	}
}
