package com.venuyeggadi.algorithms.searching;

import java.util.Scanner;

public class LinearSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int index = 0; index < n; index++)
            arr[index] = scanner.nextInt();
        int key = scanner.nextInt();

        System.out.println(linearSearch1(arr, key));
        System.out.println(linearSearch2(arr, key));
        scanner.close();
    }
    
    //O(n), O(1)
    static int linearSearch1(int[] arr, int key) {
        if(arr.length == 0)
            return -1;
        
        for(int index = 0; index < arr.length; index++) {
            if(arr[index] == key)
                return index;
        }
        
        return -1;
    }

    //O(n), O(1)
    static int linearSearch2(int[] arr, int key) {
        int index = 0;
        while(index < arr.length && arr[index] != key) //order matters
            index++;
        if(index < arr.length)
            return index;
        
        return -1;
    }

}
