package round2.Q108ConvertSortedArraytoBinarySearchTree;

import structures.TreeNode;

class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums==null || nums.length==0)
            return null;

        return sortedArrayToBSTCore(nums, 0, nums.length);
    }

    private TreeNode sortedArrayToBSTCore(int[] nums, int start, int end) {
        if (start >= end)
            return null;

        int mid = (start + end) / 2 ;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTCore(nums, start, mid);
        root.right = sortedArrayToBSTCore(nums, mid + 1, end);

        return root;
    }

}