/** 59. Spiral Matrix II
	Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

  * Example 1:
	Input: n = 3
	Output: [[1,2,3],[8,9,4],[7,6,5]]
	
  * Example 2:
	Input: n = 1
	Output: [[1]]

  * Constraints:
    * 1 <= n <= 20
*/


//#1
//O(n^2), O(1)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int firstRow = 0, lastRow = n-1;
        int firstColumn = 0, lastColumn = n-1;
        int num = 1;
        while(firstRow <= lastRow && firstColumn <= lastColumn) {
            for(int i = firstColumn; i <= lastColumn; i++)
                ans[firstRow][i] = num++;
                
            for(int i = firstRow+1; i <= lastRow; i++)
                ans[i][lastColumn] = num++;
                
            if(firstRow < lastRow) {
                for(int i = lastColumn-1; i >= firstColumn; i--)
                    ans[lastRow][i] = num++;
            }
            if(firstColumn < lastColumn) {
                for(int i = lastRow-1; i > firstRow; i--)
                    ans[i][firstColumn] = num++;
            }
            
            firstRow += 1;
            lastRow -= 1;
            firstColumn += 1;
            lastColumn -= 1;
        }
        
        return ans;
    }
}
//same solution but with single pointer
/*
*Approach: Traverse Layer by Layer in Spiral Form
	Let's devise an algorithm for the spiral traversal:
	We can observe that, for any given n, the total number of layers is given by : floor{(n+1)/2} 
	This works for both even and odd n.
	Example:
		For n = 3, layers = 2
		For n = 6, total layers = 3
		Also, for each layer, we traverse in at most 4 directions :
	In every direction, either row or column remains constant and other parameter changes (increments/decrements).
	Direction 1: From top left corner to top right corner.
		The row remains constant as layer and column increments from layer to n−layer−1
	Direction 2: From top right corner to the bottom right corner.
		The column remains constant as n-layer-1 and row increments from layer+1 to n−layer-1.
	Direction 3: From bottom right corner to bottom left corner.
		The row remains constant as n−layer−1 and column decrements from n−layer−2 to layer.
	Direction 4: From bottom right corner to top left corner.
		The column remains constant as layer and column decrements from n−layer−2 to layer+1.
	
	This process repeats (n+1)/2 times until all layers are traversed.

*Complexity Analysis
	Time Complexity: O(n^2). Here, n is given input and we are iterating over n*n matrix in spiral form.
	Space Complexity: O(1) We use constant extra space for storing cntcnt
*/
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int num = 1;
        for(int layer = 0; layer < (n+1)/2; layer++) {
            for(int i = layer; i < n-layer; i++)
                result[layer][i] = num++;
            
            for(int i = layer+1; i < n-layer; i++)
                result[i][n-1-layer] = num++;
            
            for(int i = n-layer-2; i >= layer; i--)
                result[n-1-layer][i] = num++;
            
            for(int i = n-2-layer; i > layer; i--)
                result[i][layer] = num++;
        }
        
        return result;
    }
}


//#2
/*
*Approach 2: Optimized spiral traversal
*Intuition:
	Our main aim is to walk in a spiral form and fill the array in a particular pattern.
	In the previous approach, we used a separate loop for each direction. Here, we discuss
	another optimized to achieve the same result.
*Algorithm:
	We have to walk in 4 directions forming a layer. We use an array dirdir that stores
	the changes in xx and yy co-ordinates in each direction.
	Example
		In left to right walk (direction #1), x co-ordinates remains same and y increments (x = 0, y = 1).
		In right to left walk (direction #3), x remains same and y decrements (x = 0, y = -1).
	Using this intuition, we pre-define an array dirdir having xx and yy co-ordinate changes
	for each direction. There are a total of 4 directions as discussed in the previous approach.
	The row and col variables represent the current x and y co-ordinates respectively.
	It updates based on the direction in which we are moving.
*How do we know when we have to change the direction?
	When we find the next row or column in a particular direction has a non-zero value,
	we are sure it is already traversed and we change the direction.
	Let d be the current direction index. We go to next direction in array dirdir using (d+1)%4.
	Using this we could go back to direction 1 after completing one circular traversal from
	direction 1 to direction 4 .

*It must be noted that we use floorMod in Java instead of modulo % to handle mod of negative numbers.
 This is required because row and column values might go negative and using % won't give desired
 results in such cases.

*Complexity Analysis:
	Time Complexity: O(n^2). Here, n is given input and we are iterating over n*n matrix in spiral form.
	Space Complexity: O(1) We use constant extra space for storing cntcnt.
*/
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int num = 1;
        int row = 0, col = 0;
        int direction = 0;
        while(num <= n*n) {
            result[row][col] = num++;
            int nextRow = Math.floorMod(row+directions[direction][0], n);
            int nextCol = Math.floorMod(col+directions[direction][1], n);
            // change direction if next cell is non zero
            if(result[nextRow][nextCol] != 0)
                direction = (direction+1)%4;
            
            row += directions[direction][0];
            col += directions[direction][1];
        }
        
        return result;
    }
}