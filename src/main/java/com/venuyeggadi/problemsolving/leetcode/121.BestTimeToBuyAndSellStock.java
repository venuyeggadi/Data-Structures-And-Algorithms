package com.venuyeggadi.problemsolving.leetcode;

/*
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing
   a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit,
   return 0.

 * Example 1:
    Input: prices = [7,1,5,3,6,4]
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

 * Example 2:
    Input: prices = [7,6,4,3,1]
    Output: 0
    Explanation: In this case, no transactions are done and the max profit = 0.

 * Constraints:
    * 1 <= prices.length <= 105
    * 0 <= prices[i] <= 104

 */

// Solution 1
// Bruteforce
// Time Limit Exceeded
/*
  Time complexity: O(n^2)
  Space complexity: O(1)
 */
class BestTimeToBuyAndSellStockSolution1 {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int maxProfit = 0; // Because we need to return 0 if no profit can be made

        for (int buyOn = 0; buyOn < length - 1; buyOn++) {
            for (int sellOn = buyOn + 1; sellOn < length; sellOn++) {
                int profit = prices[sellOn] - prices[buyOn];
                if(profit > maxProfit)
                    maxProfit = prices[sellOn] - prices[buyOn];
            }
        }

        return maxProfit;
    }
}


// Solution 2
// Sliding Window
/*
  Time complexity: O(n)
  Space complexity: O(1)
 */
class BestTimeToBuyAndSellStockSolution2 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyAt = prices[0];
        for (int price : prices) {
            int profit = price - buyAt;
            if (profit > 0)
                maxProfit = Math.max(profit, maxProfit);
            else
                buyAt = price;
        }

        return maxProfit;
    }
}
