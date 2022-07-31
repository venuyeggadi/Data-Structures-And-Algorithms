package com.venuyeggadi.problemsolving.leetcode;

/*
 * 36. Valid Sudoku
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated
   according to the following rules:
    * Each row must contain the digits 1-9 without repetition.
    * Each column must contain the digits 1-9 without repetition.
    * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

 * Note:
    * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
    * Only the filled cells need to be validated according to the mentioned rules.

 * Example 1:
    Input: board =
    [["5","3",".",".","7",".",".",".","."]
    ,["6",".",".","1","9","5",".",".","."]
    ,[".","9","8",".",".",".",".","6","."]
    ,["8",".",".",".","6",".",".",".","3"]
    ,["4",".",".","8",".","3",".",".","1"]
    ,["7",".",".",".","2",".",".",".","6"]
    ,[".","6",".",".",".",".","2","8","."]
    ,[".",".",".","4","1","9",".",".","5"]
    ,[".",".",".",".","8",".",".","7","9"]]
    Output: true

 * Example 2:
    Input: board =
    [["8","3",".",".","7",".",".",".","."]
    ,["6",".",".","1","9","5",".",".","."]
    ,[".","9","8",".",".",".",".","6","."]
    ,["8",".",".",".","6",".",".",".","3"]
    ,["4",".",".","8",".","3",".",".","1"]
    ,["7",".",".",".","2",".",".",".","6"]
    ,[".","6",".",".",".",".","2","8","."]
    ,[".",".",".","4","1","9",".",".","5"]
    ,[".",".",".",".","8",".",".","7","9"]]
    Output: false
    Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8.
    Since there are two 8's in the top left 3x3 sub-box, it is invalid.

 * Constraints:
    * board.length == 9
    * board[i].length == 9
    * board[i][j] is a digit 1-9 or '.'.

 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


// Solution 1
/*
Bruteforce
Time complexity: O(9^2 * 9^2 * 3^4) = O(1)
Space complexity: O(9 + 9 + 9) = O(1)
 */
class ValidSudokuSolution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set;

        for (int row = 0; row < 9; row++) {
            set = new HashSet<>();
            for (char ch : board[row]) {
                if (ch != '.' && !set.add(ch)) return false;
            }
        }

        for (int col = 0; col < 9; col++) {
            set = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                char ch = board[row][col];
                if (ch != '.' && !set.add(ch)) return false;
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                set = new HashSet<>();
                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 3; col++) {
                        char ch = board[i + row][j + col];
                        if (ch != '.' && !set.add(ch)) return false;
                    }
                }
            }
        }

        return true;
    }
}


// Solution 2
/*
One pass
Time complexity: O(9^2) = O(1)
Space complexity: O(9^2 + 9^2 + 9^2) = O(1)
 */
class ValidSudokuSolution2 {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> columnMap = new HashMap<>();
        Map<String, Set<Character>> blockMap = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    rowMap.putIfAbsent(i, new HashSet<>());
                    columnMap.putIfAbsent(j, new HashSet<>());
                    String block = i / 3 + ", " + j / 3;
                    blockMap.putIfAbsent(block, new HashSet<>());
                    if (!rowMap.get(i).add(ch) || !columnMap.get(j).add(ch) || !blockMap.get(block).add(ch))
                        return false;
                }
            }
        }

        return true;
    }
}


// Solution 3
/*
Using a single set
Time complexity: O(9^2) = O(1)
Space complexity: O(9^2) = O(1)
 */
class ValidSudokuSolution3 {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char ch = board[row][col];
                if (ch != '.') {
                    if (!seen.add(ch + " in row " + row) ||
                            !seen.add(ch + " in col " + col) ||
                            !seen.add(ch + " in block " + row / 3 + ", " + col / 3))
                        return false;
                }
            }
        }

        return true;
    }
}

