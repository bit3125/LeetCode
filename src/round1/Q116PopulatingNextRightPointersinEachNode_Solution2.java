package round1;

import structures.Node;

/**算法分析：Sn = O1
 * 本算法之所以能省去Q，达到O1的空间复杂度，是因为其利用了Node中的next字段，利用设置好的next字段代替了Q的功能
 *
 * */
public class Q116PopulatingNextRightPointersinEachNode_Solution2 {

    public Node connect(Node root) {
        if (root==null)
            return root;

        Node levelStart = root, curNode;
        while (levelStart != null) {
            curNode = levelStart;
            while (curNode != null) {//本层的next字段在遍历上一层的时候都已经设置好
                if (curNode.left!=null)
                    curNode.left.next = curNode.right;
                if (curNode.right!=null && curNode.next!=null)
                    curNode.right.next = curNode.next.left;

                curNode = curNode.next;
            }
            levelStart = levelStart.left;
        }

        return root;
    }

}
