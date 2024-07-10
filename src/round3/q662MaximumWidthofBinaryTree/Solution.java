package round3.q662MaximumWidthofBinaryTree;

import structures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode node, first = root;
        root.val = 1;
        int curLevelCnt = 1, nextLevelCnt = 0, curCnt = 0;
        int maxWidth = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            node = q.poll();
            curCnt++;
            if (curCnt == 1) {
                first = node;
            }

            // visit left
            if (node.left != null) {
                node.left.val = 2 * node.val;
                q.offer(node.left);
                nextLevelCnt++;
            }
            if (node.right != null) {
                node.right.val = 2 * node.val + 1;
                q.offer(node.right);
                nextLevelCnt++;
            }

            // end of this level
            if (curCnt == curLevelCnt) {
                // cal width
                maxWidth = Integer.max(maxWidth, node.val - first.val + 1);

                // step forward
                curCnt = 0;
                curLevelCnt = nextLevelCnt;
                nextLevelCnt = 0;
            }
        }

        return maxWidth;
    }
}