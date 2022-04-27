import java.util.*;

public class Solution1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), q = in.nextInt();
		int MOD = 1000000007;
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = in.nextInt();

		int sum = 0;

		while(q-- > 0) {
			int i = in.nextInt(), x = in.nextInt();
			if(i == -2) {
				int max = 0;
				for(int num : arr)
					if((num^x) > max)
						max = num^x;
				sum = sum + max;

			} else {
				arr[i] = x;
			}
		}

		System.out.println(sum);

		in.close();
	}
}
