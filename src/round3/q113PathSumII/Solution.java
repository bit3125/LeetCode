package round3.q113PathSumII;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return results;
        }

        preOrder(root, targetSum, 0, results, result);
        return results;
    }

    public void preOrder(TreeNode node, int targetSum, int sum, List<List<Integer>> results, List<Integer> path) {
        if (node == null) { // illegal
            return;
        }

        // visit
        sum += node.val;
        path.add(node.val);
        // leaf node
        if (node.right == null && node.left == null && sum == targetSum) {
            results.add(new ArrayList<>(path));
        }

        // left & right
        if (node.left != null) {
            preOrder(node.left, targetSum, sum, results, path);
        }
        if (node.right != null) {
            preOrder(node.right, targetSum, sum, results, path);
        }

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
    }
}