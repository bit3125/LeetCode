package round3.q129SumRoottoLeafNumbers;

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
    class NodeResult {
        int leafNodeCnt;
        int allSum;
        int base;

        NodeResult(int leafNodeCnt, int allSum, int base) {
            this.leafNodeCnt = leafNodeCnt;
            this.allSum = allSum;
            this.base = base;
        }
    }
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return core(root).allSum;
    }

    // Return:
    // - the count of leaf nodes of this subTree;
    // - the pathSum of this subTree;
    // - the depth of this subTree
    // post-order
    public NodeResult core(TreeNode root) {
        if (root == null) { // robust
            return new NodeResult(0, 0, 1);
        }

        NodeResult leftResult = new NodeResult(0, 0, 1), rightResult =  new NodeResult(0, 0, 1), curResult;
        if (root.left != null) {
            leftResult = core(root.left);
        }
        if (root.right != null) {
            rightResult = core(root.right);
        }

        int curLeafCnt, curAllSum, curDepth, curBase;
        curLeafCnt = leftResult.leafNodeCnt + rightResult.leafNodeCnt;
        curBase = Integer.max(leftResult.base, rightResult.base) * 10;
        if (curLeafCnt == 0) { // this is a leaf node
            curLeafCnt = 1;
            curBase = 1;
        }
        curAllSum = leftResult.allSum + rightResult.allSum + root.val * curBase * curLeafCnt;

        curResult = new NodeResult(curLeafCnt, curAllSum, curBase);
        return curResult;
    }
}