package leetcode.solutions;

import leetcode.structures.TreeNode;

public class Q617MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1==null && t2==null) {
            return null;
        } else if (t1 == null || t2 == null) {
            TreeNode root = new TreeNode(t1 == null ? t2.val : t1.val);
            root.left = mergeTrees(t1==null?t2.left:t1.left, null); //***bug:root.left = null;
            root.right = mergeTrees(t1==null?t2.right:t1.right, null);
            return root;
        }
        //else: t1!=null && t2!=null
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);

        return root;
    }

}
