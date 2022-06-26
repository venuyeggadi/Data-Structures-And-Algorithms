package com.venuyeggadi.problemsolving.leetcode;

/** 832. Flipping an Image
    Given an n x n binary matrix image, flip the image horizontally, then invert it,
    and return the resulting image.
    To flip an image horizontally means that each row of the image is reversed.
    For example, flipping [1,1,0] horizontally results in [0,1,1].
    To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
    For example, inverting [0,1,1] results in [1,0,0].
    
  * Example 1:
    Input: image = [[1,1,0],[1,0,1],[0,0,0]]
    Output: [[1,0,0],[0,1,0],[1,1,1]]
    Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
    Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]

  * Example 2:
    Input: image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
    Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
    Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
    Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]

  * Constraints:
    * n == image.length
    * n == image[i].length
    * 1 <= n <= 20
    * images[i][j] is either 0 or 1.
*/


//#1
//O(n^2), O(n^2)
class FlippingAnImageSolution1 {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        int[][] a = new int[n][n];
        int temp;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                a[i][n-1-j] = image[i][j];
    
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                a[i][j] = 1^a[i][j];
        
        return a;
    }
}


//#2
//O(n^2), O(1)
class FlippingAnImageSolution2 {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        int temp;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n/2; j++) {
                temp = image[i][j];
                image[i][j] = image[i][n-1-j];
                image[i][n-1-j] = temp;
            }
        }
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                image[i][j] = 1^image[i][j];
        
        return image;
    }
}


//#3
//O(n^2), O(1)
/* We traverse upto the center element, i.e., (n+1)/2 th element because we need to invert
   that also.
*/
class FlippingAnImageSolution3 {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        int temp;
        for(int[] row : image) {
            for(int j = 0; j < (n+1)/2; j++) {
                temp = 1^row[j];
                row[j] = 1^row[n-1-j];
                row[n-1-j] = temp;
            }
        }
        
        return image;
    }
}