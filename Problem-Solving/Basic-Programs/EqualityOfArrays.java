import java.util.Arrays;

class EqualityOfArrays {
	public static void main(String[] args) {
		int[] a1 = {1, 2, 5, 3};
		int[] a2 = {1, 2, 5, 3};

		System.out.println(Arrays.equals(a1, a2));

		System.out.println(areEqual(a1, a2));
	}

	static boolean areEqual(int[] a1, int[] a2) {
		if(a1.length != a2.length)
			return false;
		for(int i = 0; i < a1.length; i++) {
			if(a1[i] != a2[i])
				return false;
		}

		return true;
	}
}