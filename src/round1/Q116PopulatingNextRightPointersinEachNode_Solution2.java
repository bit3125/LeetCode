package round1;

import structures.Node;

/**�㷨������Sn = O1
 * ���㷨֮������ʡȥQ���ﵽO1�Ŀռ临�Ӷȣ�����Ϊ��������Node�е�next�ֶΣ��������úõ�next�ֶδ�����Q�Ĺ���
 *
 * */
public class Q116PopulatingNextRightPointersinEachNode_Solution2 {

    public Node connect(Node root) {
        if (root==null)
            return root;

        Node levelStart = root, curNode;
        while (levelStart != null) {
            curNode = levelStart;
            while (curNode != null) {//�����next�ֶ��ڱ�����һ���ʱ���Ѿ����ú�
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
