/**�㷨������Tn = On, Sn = O1
 *
 * BST������һ���������ݽṹ�� ������������Ļ��ҵ���k���������O1�ĸ��Ӷȣ�����Ļ�����On�ĸ��Ӷȣ�
 * ����ΪBST�����������ǽ��䰴���������ת�������������������ô���ӶȾ���On���ռ�����ΪOn
 *
 * ���ڿ���ֱ�������������ԣ����������������������Ĺ��̾�������ģ���ʹ��ȫ�ֱ����ķ�����������������
 * */

package round1;

import structures.TreeNode;

public class Q230KthSmallestElementinaBST {

    public int kthSmallest(TreeNode root, int k) {
        if (root==null || k<=0)
            return -1;

        int[] result = new int[1];
        curIdx = 0;
        hasFound = false;
        kthSmallestCore(root, k, result);
        return result[0];
    }

    private int curIdx;
    private boolean hasFound;
    public void kthSmallestCore(TreeNode root, int k, int[] result) {
        if (hasFound || root==null)
            return;

        kthSmallestCore(root.left, k, result);
        //visit
        curIdx++;
        if (curIdx == k) {
            result[0] = root.val;
            return;
        }
        kthSmallestCore(root.right, k, result);
    }

}
