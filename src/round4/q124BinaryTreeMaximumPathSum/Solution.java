package round4.q124BinaryTreeMaximumPathSum;

import structures.TreeNode;

class Solution {
    int maxPath;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        maxPath = Integer.MIN_VALUE;
        core(root);
        return maxPath;
    }

    public int core(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxSinglePathLeft = core(root.left);
        int maxSinglePathRight = core(root.right);
        maxPath = Integer.max(maxPath, root.val + Integer.max(maxSinglePathLeft, 0) + Integer.max(maxSinglePathRight, 0));

        return root.val + Integer.max(0, Integer.max(maxSinglePathLeft, maxSinglePathRight));
    }
}
