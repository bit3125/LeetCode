package round2.Q104MaximumDepthofBinaryTree.solution1;

import structures.TreeNode;

class Solution {

    public int maxDepth(TreeNode root) {
        if (root==null)
            return 0;

        return Integer.max(maxDepth(root.left), maxDepth(root.right)) + 1 ;
    }

}