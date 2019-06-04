package leetcode.solutions;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.structures.Node;

public class Q116PopulatingNextRightPointersinEachNode_Solution1 {

    public Node connect(Node root) {
        if (root==null)
            return root;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        Node curNode = null , prevNode = null;
        int curLevelCnt = 0, curLevelSize = 1;

        while (!q.isEmpty()) {
            curNode = q.poll();
            curNode.next = prevNode;
            curLevelCnt++;

            if (curNode.right!=null) //right first
                q.offer(curNode.right);
            if (curNode.left!=null)
                q.offer(curNode.left);

            if (curLevelCnt == curLevelSize) {
                prevNode = null;
                curLevelSize = q.size();
                curLevelCnt = 0;
            } else {
                prevNode = curNode;
            }
        }

        return root;
    }

}
