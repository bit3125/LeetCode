package round2.Q236LowestCommonAncestorofaBinaryTree.solution1;

import structures.TreeNode;

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null || p==null || q==null)
            return null;

        return lowestCommonAncestorCore(root, p, q);
    }

    private TreeNode lowestCommonAncestorCore(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null)
            return null;

        if (root==p || root==q) //important!!!!!do it first
            return root;
        TreeNode leftRet, rightRet;
        leftRet = lowestCommonAncestorCore(root.left, p, q);
        rightRet = lowestCommonAncestorCore(root.right, p, q);

        if (leftRet!=null && rightRet!=null)
            return root;
        return leftRet==null?rightRet:leftRet;
    }
}