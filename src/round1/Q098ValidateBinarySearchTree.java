package round1;

import structures.TreeNode;

public class Q098ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValidBSTCore(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * Params:
     * - leftBound, rightBound: [, ]
     * */
    public boolean isValidBSTCore(TreeNode root, long leftBound, long rightBound) {
        if (root == null)
            return true;

        return leftBound <= root.val && root.val <= rightBound
                && isValidBSTCore(root.left, leftBound, root.val-1L)
                && isValidBSTCore(root.right, root.val+1L, rightBound);
    }

}
