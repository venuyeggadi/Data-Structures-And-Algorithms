package com.venuyeggadi.problemsolving.leetcode;

/**
 * Bruteforce
 * Time:
 *     update() -> O(1)
 *     sumRange() -> O(n)
 * Space: O(1) for all
 *
 * Using prefix sum here is worse because it take extra space -> O(n)
 */
class NumArray1 {
    int[] nums;

    public NumArray1(int[] nums) {
        this.nums = nums;
    }

    public void update(int index, int val) {
        this.nums[index] = val;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++)
            sum += this.nums[i];

        return sum;
    }
}


/**
 * Time: as it's always a balanced tree,
 *     creation -> O(n)
 *     update() -> O(log n)
 *     sumRange() -> O(log n)
 * Space:
 *     O(n) for tree,
 *     update() -> O(log n) for recursive stack
 *     sumRange() -> O(log n) for recursive stack
 */
class NumArray2 {
    private SegmentTreeNode root;

    public NumArray2(int[] nums) {
        this.root = buildSegmentTree(nums, 0, nums.length - 1);
    }

    public void update(int index, int val) {
        root.update(index, val);
    }

    public int sumRange(int left, int right) {
        return root.rangeSum(left, right);
    }

    private static SegmentTreeNode buildSegmentTree(int[] nums, int l, int r) {
        if (l == r)
            return new SegmentTreeNode(l, r, nums[l], null, null);

        int mid = (l + r) / 2;

        SegmentTreeNode left = buildSegmentTree(nums, l, mid);
        SegmentTreeNode right = buildSegmentTree(nums, mid + 1, r);
        return new SegmentTreeNode(l, r, left.sum + right.sum, left, right);
    }
}

class SegmentTreeNode {
    private int leftIndex;
    private int rightIndex;
    public int sum;
    private SegmentTreeNode left;
    private SegmentTreeNode right;

    public SegmentTreeNode(int leftIndex, int rightIndex, int sum, SegmentTreeNode left, SegmentTreeNode right) {
        this.leftIndex = leftIndex;
        this.rightIndex = rightIndex;
        this.sum = sum;
        this.left = left;
        this.right = right;
    }

    public void update(int index, int value) {
        if (this.leftIndex == this.rightIndex) {
            this.sum = value;
            return;
        }

        int mid = (this.leftIndex + this.rightIndex) / 2;

        if (index <= mid)
            this.left.update(index, value);
        else
            this.right.update(index, value);

        this.sum = this.left.sum + this.right.sum;
    }

    public int rangeSum(int l, int r) {
        if (this.leftIndex == l && this.rightIndex == r)
            return this.sum;

        int mid = (this.leftIndex + this.rightIndex) / 2;

        if (l > mid)
            return this.right.rangeSum(l, r);
        else if (r <= mid)
            return this.left.rangeSum(l, r);

        return this.left.rangeSum(l, mid) + this.right.rangeSum(mid + 1, r);
    }
}