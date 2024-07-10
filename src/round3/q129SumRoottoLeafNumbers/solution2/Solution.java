package round3.q129SumRoottoLeafNumbers.solution2;


import structures.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int sum;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        sum = 0;
        core(root, 0);
        return sum;
    }

    public void core(TreeNode root, int prevPathSum) {
        if (root == null) { // robust
            return;
        }

        int curPathSum = prevPathSum * 10 + root.val;
        if (root.right == null && root.left == null) { // is leaf
            sum += curPathSum;
            return;
        }
        // else
        if (root.left != null) {
            core(root.left, curPathSum);
        }
        if (root.right != null) {
            core(root.right, curPathSum);
        }
    }
}
