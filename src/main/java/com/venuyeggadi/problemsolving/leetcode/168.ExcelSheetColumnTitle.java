package com.venuyeggadi.problemsolving.leetcode;


/**
 * O(Log26(N))
 */
// Iterative
class ExcelSheetColumnTitle_Solution1 {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            int reminder = (columnNumber - 1) % 26;
            columnNumber = (columnNumber - 1) / 26;
            sb.append((char) ('A' + reminder));
        }

        return sb.reverse().toString();
    }
}

// Recursive
class ExcelSheetColumnTitle_Solution1Way2 {
    public String convertToTitle(int columnNumber) {
        if (columnNumber == 0)
            return "";

        columnNumber -= 1;
        return convertToTitle(columnNumber / 26) + (char)('A' + columnNumber % 26);
    }
}