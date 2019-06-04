/**�㷨���������������ζ��棬 Tn = On, Sn = O1
 * ���к�������� Core����return����ֵ������״̬��
 * ��res[0]=maxPathValue ��ʾ�����������·������
 * , res[1]=maxStrightPathValue ��ʾ�Ը�rootΪ�˵�����straight·������
 * ��״̬ת�Ʒ���ֱ�Ӽ�����
 * ����ʼ״̬��Ҷ�ڵ��˫״̬��ʼ��ΪInteger.MIN_VALUE.��ΪDP������һֱ��ɸѡ��maxֵ������minvalue�ɱ�ʾ����
 * */

package leetcode.solutions;

import leetcode.structures.TreeNode;
import java.util.Arrays;

public class Q124BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {
        if (root==null)
            return 0;
        return maxPathSumCore(root)[0];
    }

    /**
     * Return : int[], [0]-maxPathValue, [1]-maxStrightPathValue
     * */
    public int[] maxPathSumCore(TreeNode root){
        int[] curRes = new int[2];
        if (root == null) { //�ݹ����
            Arrays.fill(curRes, Integer.MIN_VALUE); //***bug:�տ�ʼ��0��ʼ��������root.val<0�������bug
            return curRes;
        }

        int[] leftRes = maxPathSumCore(root.left);
        int[] rightRes = maxPathSumCore(root.right);
        int[] sonsMaxRes = new int[2];
        sonsMaxRes[0] = Integer.max(leftRes[0], rightRes[0]);
        sonsMaxRes[1] = Integer.max(leftRes[1], rightRes[1]);

        curRes[0] = Integer.max(sonsMaxRes[0], root.val + (leftRes[1]>0?leftRes[1]:0) + (rightRes[1]>0?rightRes[1]:0) );
        curRes[1] = root.val + (sonsMaxRes[1]>0?sonsMaxRes[1]:0); //***bug:��Ŀ���ʽ�����һ��Ҫ�����ţ���
        return curRes;
    }

}
