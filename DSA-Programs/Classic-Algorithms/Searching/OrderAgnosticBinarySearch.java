import java.util.Scanner;

public class OrderAgnosticBinarySearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];

        for(int i = 0; i < n; i++)
            array[i] = scanner.nextInt();

        int key = scanner.nextInt();
        System.out.println(orderAgnosticBinarySearch(array, key));
        scanner.close();
    }
    
    //O(log(n)), O(1)
    static int orderAgnosticBinarySearch(int[] array, int key) {
        int start = 0;
        int end = array.length - 1;

        boolean isAscending = array[start] < array[end];

        while(start <= end) {
            int mid = start + (end-start)/2;

            if(key == array[mid])
                return mid;
            
            if(isAscending) {
                if(key < array[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {
                if(key > array[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }

        return -1;
    }

}
