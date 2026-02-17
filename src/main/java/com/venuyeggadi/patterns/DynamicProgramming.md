# Dynamic Programming
* Solving a problem as a result of the combination of sub-problems. Caching the results of the sub-problems
  so that they can be re-used for overlapping sub-problems.
* Top-down (memoization) -> Take a recursive solution and add caching to it.
* Bottom-up (tabulation) (sometimes referred to as true dynamic programming)
* 1D Dynamic Programming
    * [Fibonacci](https://leetcode.com/problems/fibonacci-number/) - [Solution](./problemsolving/leetcode/509.FibonacciNumber.java)
    * [Climbing Stairs](https://leetcode.com/problems/climbing-stairs/) - [Solution](./problemsolving/leetcode/70.ClimbingStairs.java)
    * [House Robber](https://leetcode.com/problems/house-robber/) - [Solution](./problemsolving/leetcode/198.HouseRobber.java)
    * Solutions are recursive most of the time.
        1. Come up with a Recursive solution, then
        2. Memoize (Top-down), then
        3. Tabulation (Bottom-up), then
        4. See if space can be optimized (may not always need all previous values, only last few values are enough for most of the problems)
* 2D Dynamic Programming
    * [Unique Paths](https://leetcode.com/problems/unique-paths/) - [Solution](./problemsolving/leetcode/62.UniquePaths.java)
    * [Unique Paths II](https://leetcode.com/problems/unique-paths-ii/) - [Solution](./problemsolving/leetcode/63.UniquePathsII.java)
    * [Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/) - [Solution](./problemsolving/leetcode/1143.LongestCommonSubsequence.java)
* 0/1 Knapsack
    * [Partition Equal Subset Sum](./problemsolving/leetcode/PartitionEqualSubsetSum.java)
    * [Target Sum](./problemsolving/leetcode/TargetSum.java)
    * [Ones and Zeroes](./problemsolving/leetcode/OnesAndZeroes.java)
    * [Last Stone Weight](./problemsolving/leetcode/LastStoneWeight.java)
* Unbounded Knapsack
    * [Coin Change](./problemsolving/leetcode/CoinChange.java)
    * [Coin Change II](./problemsolving/leetcode/CoinChangeII.java)
    * [Minimum Cost for Tickets](./problemsolving/leetcode/MinimumCostForTickets.java)
* Least Common Subsequence (LCS)
    * [Longest Common Subsequence](./problemsolving/leetcode/LongestCommonSubsequence.java)
    * [Edit Distance](./problemsolving/leetcode/EditDistance.java)
    * [Distinct Subsequences](./problemsolving/leetcode/DistinctSubsequences.java)
    * [Interleaving String](./problemsolving/leetcode/InterleavingString.java)
    * [ShortestCommonSupersequence](./problemsolving/leetcode/ShortestCommonSupersequence.java)
* Palindromes
    * [Longest Palindromic Substring](./problemsolving/leetcode/LongestPalindromicSubstring.java)
    * [Palindromic Substrings](./problemsolving/leetcode/PalindromicSubstrings.java)
    * [Longest Palindromic Subsequence](./problemsolving/leetcode/LongestPalindromicSubsequence.java)
