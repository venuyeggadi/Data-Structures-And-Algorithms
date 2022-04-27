import java.util.HashSet;
import java.util.*;

class DuplicatesInArray {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] a = new int[in.nextInt()];
		for(int i = 0; i < a.length; i++)
			a[i] = in.nextInt();

		//#1 Bruteforce O(n^2), O(1)
		boolean found = false;
		for(int i = 0; i < a.length; i++) {
			for(int j = i + 1; j < a.length; j++) {
				if(a[i] == a[j]) {
					System.out.println(a[i] + " is duplicated.");
					found = true;
				}
			}
		}
		if(!found)
			System.out.println("No duplicates found.");

		//#2 Using Set; O(n), O(n)
		found = false;
		Set<Integer> intSet1 = new HashSet<>();
		for(Integer i : a) {
			if(intSet1.contains(i)) {
				System.out.println(i + " is duplicated.");
				found = true;
			}
			else
				intSet1.add(i);
		}
		if(!found)
			System.out.println("No duplicates found.");

		//same approch with only add method
		found = false;
		Set<Integer> intSet2 = new HashSet<>();
		for(Integer i : a) {
			if(!intSet2.add(i)) {
				System.out.println(i + " is duplicated.");
				found = true;
			}
		}
		if(!found)
			System.out.println("No duplicates found.");
	}
}