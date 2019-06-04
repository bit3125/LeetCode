package leetcode.solutions;

import leetcode.structures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**算法分析：LevelOrder
 * 非TopInterview， 非TopLiked
 *
 * */

public class Q199BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root==null)
            return results;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        TreeNode curNode ;
        int levelCnt = 0, levelTotal = 1;
        while (!q.isEmpty()) {
            curNode = q.poll();
            if (curNode.left!=null)
                q.offer(curNode.left);
            if (curNode.right!=null)
                q.offer(curNode.right);

            levelCnt++;
            if (levelCnt == levelTotal) { //curlevel is end
                results.add(curNode.val);

                levelCnt = 0;
                levelTotal = q.size();
            }
        }

        return results;
    }

}
