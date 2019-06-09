package round2.Q104MaximumDepthofBinaryTree.solution2;

import structures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int maxDepth(TreeNode root) {
        if (root==null)
            return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode curNode ;
        int curCnt = 0, curNum = 1;
        int depth = 0;

        while (!q.isEmpty()) {
            curNode = q.poll();
            curCnt++;

            if (curNode.left != null)
                q.offer(curNode.left);
            if (curNode.right != null)
                q.offer(curNode.right);

            if (curCnt == curNum) {
                depth++;

                curCnt = 0;
                curNum = q.size();
            }
        }

        return depth;
    }

}
