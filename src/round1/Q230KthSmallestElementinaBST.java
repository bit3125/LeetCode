/**算法分析：Tn = On, Sn = O1
 *
 * BST本身是一个有序数据结构， 若是有序数组的话找到第k大的数就是O1的复杂度，链表的话就是On的复杂度，
 * 故作为BST，最坏的情况就是将其按照中序遍历转化成有序数组再输出那么复杂度就是On，空间消耗为On
 *
 * 现在考虑直接利用其有序性，进行中序遍历，本身遍历的过程就是有序的，故使用全局变量的方法中序遍历输出即可
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
