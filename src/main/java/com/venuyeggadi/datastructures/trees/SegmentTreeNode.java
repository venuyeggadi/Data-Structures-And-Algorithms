package com.venuyeggadi.datastructures.trees;

public class SegmentTreeNode {
    public SegmentTreeNode left;
    public SegmentTreeNode right;
    public int sum;
    public int leftIndex;
    public int rightIndex;

    public SegmentTreeNode(SegmentTreeNode left, SegmentTreeNode right, int leftIndex, int rightIndex, int sum) {
        this.left = left;
        this.right = right;
        this.sum = sum;
        this.leftIndex = leftIndex;
        this.rightIndex = rightIndex;
    }

    public void update(int index, int value) {
        if (this.leftIndex == this.rightIndex){
            this.sum = value;
            return;
        }

        int mid = this.leftIndex + this.rightIndex;
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

        if (r <= mid) // in left tree
            return this.left.rangeSum(l, r);
        else if (l > mid) // in right tree
            return this.right.rangeSum(l, r);
        else // spanning left and right trees
            return rangeSum(l, mid) + rangeSum(mid + 1, r);
    }


    public static SegmentTreeNode build(int[] nums, int l, int r) {
        if (l == r)
            new SegmentTreeNode(null, null, l, r, nums[l]);

        int mid = (l + r) / 2;
        SegmentTreeNode left = SegmentTreeNode.build(nums, l, mid);
        SegmentTreeNode right = SegmentTreeNode.build(nums, mid + 1, r);
        SegmentTreeNode node = new SegmentTreeNode(left, right, l, r, left.sum + right.sum);

        return node;
    }
}
