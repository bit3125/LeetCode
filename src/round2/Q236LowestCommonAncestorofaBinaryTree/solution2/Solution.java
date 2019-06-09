package round2.Q236LowestCommonAncestorofaBinaryTree.solution2;

import structures.TreeNode;
import java.util.Deque;
import java.util.LinkedList;

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null || p==null || q==null)
            return null;

        Deque<TreeNode> path = new LinkedList<>();
        Deque<TreeNode>[] pathRes = new LinkedList[2];
        recordPath(root, p, q, path, pathRes);

        TreeNode prev = null ; //redundant
        while ( !pathRes[0].isEmpty() && !pathRes[1].isEmpty() //***bug
                && pathRes[0].getFirst() == pathRes[1].getFirst()) {
            prev = pathRes[0].getFirst();
            pathRes[0].removeFirst();
            pathRes[1].removeFirst();
        }

        return prev;
    }

    private void recordPath(TreeNode root, TreeNode p, TreeNode q,
                                       Deque<TreeNode> path, Deque<TreeNode>[] pathRes) {
        if (root == null)
            return;
        if (pathRes[0]!=null && pathRes[1]!=null)
            return;

        // visit
        path.addLast(root);
        if (root == p || root == q) {
            if (root == p)
                pathRes[0] = new LinkedList<>(path);
            else
                pathRes[1] = new LinkedList<>(path);
        }
        // left & right
        recordPath(root.left, p, q, path, pathRes);
        recordPath(root.right, p, q, path, pathRes);

        //backtracking
        path.removeLast();
    }

    //***debugging
    private void printDeque(Deque<TreeNode> root) {
        for (TreeNode n:root){
            System.out.print(n.val + ",");
        }
        System.out.println();
    }

}