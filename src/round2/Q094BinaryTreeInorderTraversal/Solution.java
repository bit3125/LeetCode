package round2.Q094BinaryTreeInorderTraversal;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();

        inorderTraversalCore(root, results);
        return results;
    }

    public void inorderTraversalCore(TreeNode root, List<Integer> results){
        if (root==null)
            return;

        inorderTraversalCore(root.left, results);
        results.add(root.val);
        inorderTraversalCore(root.right, results);
    }
}