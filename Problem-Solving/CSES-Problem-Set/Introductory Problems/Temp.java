import java.util.Scanner;

class Temp {

	static final Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int n = in.nextInt();

		long answer = 0, max = 0, x;
		for(int i = 0; i < n; i++) {
			x = in.nextInt();
			max = Math.max(max, x);
			answer += max - x;
		}

		System.out.println(answer);
	}
}