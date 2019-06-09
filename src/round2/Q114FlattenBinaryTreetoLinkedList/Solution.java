package round2.Q114FlattenBinaryTreetoLinkedList;


import structures.TreeNode;

class Solution {

    public void flatten(TreeNode root) {
        if (root==null)
            return ;

        TreeNode left = root.left, right = root.right;
        //clear
        root.left = null;
        root.right = null;
        //flatten
        flatten(left);
        flatten(right);
        mergeList(mergeList(root, left), right);
    }

    /**
     *
     * @param l1: clear list
     * @param l2 clear list
     * @return
     */
    private TreeNode mergeList(TreeNode l1, TreeNode l2) {
        if (l1==null || l2==null)
            return l1==null?l2:l1;

        //else: l1!=null && l2!=null
        TreeNode p = l1;
        while (p.right != null)
            p = p.right;
        p.right = l2;
        return l1;
    }

}