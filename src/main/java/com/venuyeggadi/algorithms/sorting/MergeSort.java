package com.venuyeggadi.algorithms.sorting;

class MergeSort
{
    public static void sort(int[] a) {

        mergeSort(a, 0, a.length - 1);
    }

    private static void mergeSort(int[] a, int start, int end) {
        if(end <= start)
            return;

        int mid = (start + end) / 2;
        mergeSort(a, start, mid);
        mergeSort(a,mid + 1, end);

        merge(a, start, mid, end);
    }
    
    private static void merge(int arr[], int start, int mid, int end) {
        int[] leftArray = new int[mid - start + 1];
        int[] rightArray = new int[end - mid]; // end - (mid + 1) + 1

        for (int i = 0; i < leftArray.length; ++i)
            leftArray[i] = arr[start + i];
        for (int i = 0; i < rightArray.length; ++i)
            rightArray[i] = arr[mid + 1 + i];
 
        int leftArrayIndex = 0, rightArrayIndex = 0, resultArrayIndex = start;

        // Merge: way 1
        while (leftArrayIndex <  leftArray.length && rightArrayIndex < rightArray.length)
        {
            if (leftArray[leftArrayIndex] <= rightArray[rightArrayIndex])
                arr[resultArrayIndex++] = leftArray[leftArrayIndex++];
            else
                arr[resultArrayIndex++] = rightArray[rightArrayIndex++];
        }

        while (leftArrayIndex < leftArray.length)
            arr[resultArrayIndex++] = leftArray[leftArrayIndex++];

        while (rightArrayIndex < rightArray.length)
            arr[resultArrayIndex++] = rightArray[rightArrayIndex++];

        // Merge: way 2
//        while (resultArrayIndex <= end)
//        {
//            if (leftArrayIndex == leftArray.length)
//                arr[resultArrayIndex] = rightArray[rightArrayIndex++];
//            else if (rightArrayIndex == rightArray.length)
//                arr[resultArrayIndex] = leftArray[leftArrayIndex++];
//            else if (leftArray[leftArrayIndex] <= rightArray[rightArrayIndex])
//                arr[resultArrayIndex] = leftArray[leftArrayIndex++];
//            else
//                arr[resultArrayIndex] = rightArray[rightArrayIndex++];
//
//            resultArrayIndex++;
//        }
    }
}