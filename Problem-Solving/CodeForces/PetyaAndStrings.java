import java.io.*;
import java.util.Scanner;
import static java.lang.Math.*;

public class PetyaAndStrings {

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
		String s1 = in.next().toLowerCase();
		String s2 = in.next().toLowerCase();

		int comp = s1.compareTo(s2);
		if(comp == 0)
			System.out.println(comp);
		else
			System.out.println(comp/abs(comp));


		in.close();
	}
}
