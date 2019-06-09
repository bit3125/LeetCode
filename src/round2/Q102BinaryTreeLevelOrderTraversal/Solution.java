package round2.Q102BinaryTreeLevelOrderTraversal;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();

        if (root==null)
            return results;

        List<Integer> result = new ArrayList<>();
        int curCnt = 0, curSize = 1;
        TreeNode curNode ;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            curNode = q.poll();
            result.add(curNode.val);
            curCnt++;

            if (curNode.left!=null)
                q.offer(curNode.left);
            if (curNode.right!=null)
                q.offer(curNode.right);

            if (curCnt == curSize) {
                curCnt = 0;
                curSize = q.size();
                results.add(result);
                result = new ArrayList<>();
            }
        }

        return results;
    }

}