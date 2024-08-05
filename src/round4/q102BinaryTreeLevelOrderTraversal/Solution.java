package round4.q102BinaryTreeLevelOrderTraversal;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode cur;
        int curCnt = 0, curLevelTotalCnt = 1, nextLevelTotalCnt = 0;
        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            cur = q.poll();
            curCnt++;
            result.add(cur.val);
            if (cur.left != null) {
                q.offer(cur.left);
                nextLevelTotalCnt++;
            }
            if (cur.right != null) {
                q.offer(cur.right);
                nextLevelTotalCnt++;
            }

            if (curCnt == curLevelTotalCnt) {
                curCnt = 0;
                curLevelTotalCnt = nextLevelTotalCnt;
                nextLevelTotalCnt = 0;

                results.add(result);
                result = new ArrayList<>();
            }
        }

        return results;
    }
}