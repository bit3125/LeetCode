package round2.Q103BinaryTreeZigzagLevelOrderTraversal;


import structures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null)
            return results;

        TreeNode curNode ;
        Stack<TreeNode> s1 = new Stack<>(), s2 = new Stack<>(), sTmp;
        List<Integer> result = new ArrayList<>();
        s1.push(root);
        boolean isOdd = true;
        while (!s1.isEmpty()) {
            curNode = s1.pop();
            result.add(curNode.val);

            if (isOdd) {
                if (curNode.left != null)
                    s2.push(curNode.left);
                if (curNode.right != null)
                    s2.push(curNode.right);
            } else {
                if (curNode.right != null)
                    s2.push(curNode.right);
                if (curNode.left != null)
                    s2.push(curNode.left);
            }

            if (s1.isEmpty()) {
                sTmp = s1;
                s1 = s2;
                s2 = sTmp;
                results.add(result);
                result = new ArrayList<>();
                isOdd = !isOdd;
            }

        }

        return results;
    }

}