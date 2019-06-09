package round2.Q230KthSmallestElementinaBST;

import structures.TreeNode;

class Solution {

    private int cnt;

    public int kthSmallest(TreeNode root, int k) {
        if (root==null)
            return -1;

        int[] result = new int[1];
        cnt = 0;
        helper(root, k, result);
        return result[0];
    }

    public void helper(TreeNode root, int k, int[] result) {
        if (root==null || cnt>=k)
            return;

        helper(root.left, k, result);
        cnt++;
        if (cnt == k) {
            result[0] = root.val;
            return;
        }
        helper(root.right, k, result);
    }

}