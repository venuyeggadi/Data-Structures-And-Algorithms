import java.util.Scanner;

class InsertionSort {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] arr3 = new int[n];
        for(int i = 0; i < n; i++)
            arr1[i] = arr2[i] = arr3[i] = in.nextInt();

        InsertionSortIterative(arr1);
        InsertionSortIterative1(arr2);
        InsertionSortRecursive(arr3, 1);

        for(int num : arr1)
            System.out.print(num+" ");
        System.out.println();

        for(int num : arr2)
            System.out.print(num+" ");
        System.out.println();
        
        for(int num : arr3)
            System.out.print(num+" ");
        System.out.println();
    }

    static void InsertionSortIterative(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            for(int j = i; j > 0 && arr[j] < arr[j-1]; j--){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
    }

    static void InsertionSortIterative1(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int num = arr[i];
            int j;
            for(j = i; j > 0 && num < arr[j-1]; j--){
                arr[j] = arr[j-1];
            }
            arr[j] = num;
        }
    }

    static void InsertionSortRecursive(int[] arr, int i) {
        if( i == arr.length)
            return;
        for(int j = i; j > 0 && arr[j] < arr[j-1]; j--) {
            int temp = arr[j];
            arr[j] = arr[j-1];
            arr[j-1] = temp;
        }
        InsertionSortRecursive(arr, i+1);
    }
}
