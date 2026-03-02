package com.venuyeggadi.problemsolving.leetcode;


class VersionControl {
    public boolean isBadVersion(int mid) {
        return true; // Fake implementation;
    }
}


/**
 * --- Time Limit Exceeded ---
 * Bruteforce - Linear Search
 *
 * Time: O(n)
 * Space: O(1)
 */
class FirstBadVersion_Solution1 extends  VersionControl {
    public int firstBadVersion(int n) {
        for (int i = 1; i <= n; ++i)
            if (isBadVersion(i))
                return i;

        return -1;
    }
}


/**
 * Binary Search
 *
 * Time: O(log n)
 * Space: O(1)
 */
class FirstBadVersion_Solution2 extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 0, r = n;

        while (true) {
            int mid = l + (r - l) / 2;
            boolean isBad = isBadVersion(mid), isPreviousBad = isBadVersion(mid - 1);
            if (isBad && !isPreviousBad)
                return mid;
            if (isBad)
                r = mid - 1;
            else
                l = mid + 1;
        }
    }
}

/**
 * Binary Search
 * Converging to the answer.
 *
 * Time: O(log n)
 * Space: O(1)
 */
class FirstBadVersion_Solution3 extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1, r = n;

        while (l < r) {
            int mid = l + (r - l) / 2;
            boolean isBad = isBadVersion(mid);
            if (isBad)
                r = mid;
            else
                l = mid + 1;
        }

        return l;
    }
}

/**
 * Binary Search
 * Converging to the answer.
 *
 * Time: O(log n)
 * Space: O(1)
 */
class FirstBadVersion_Solution4 extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        int firstBadVersion = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            boolean isBad = isBadVersion(mid);
            if (isBad) {
                firstBadVersion = mid;
                r = mid - 1;
            }
            else
                l = mid + 1;
        }

        return firstBadVersion;
    }
}