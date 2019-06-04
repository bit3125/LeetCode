/**算法分析：本质是树形动规， Tn = On, Sn = O1
 * 进行后序遍历， Core方法return两个值（两个状态）
 * ，res[0]=maxPathValue 表示该子树中最大路径长度
 * , res[1]=maxStrightPathValue 表示以该root为端点的最大straight路径长度
 * ，状态转移方程直接见代码
 * ，初始状态：叶节点的双状态初始化为Integer.MIN_VALUE.因为DP过程中一直是筛选出max值，故用minvalue可表示弃用
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
        if (root == null) { //递归出口
            Arrays.fill(curRes, Integer.MIN_VALUE); //***bug:刚开始用0初始化，遇到root.val<0的情况就bug
            return curRes;
        }

        int[] leftRes = maxPathSumCore(root.left);
        int[] rightRes = maxPathSumCore(root.right);
        int[] sonsMaxRes = new int[2];
        sonsMaxRes[0] = Integer.max(leftRes[0], rightRes[0]);
        sonsMaxRes[1] = Integer.max(leftRes[1], rightRes[1]);

        curRes[0] = Integer.max(sonsMaxRes[0], root.val + (leftRes[1]>0?leftRes[1]:0) + (rightRes[1]>0?rightRes[1]:0) );
        curRes[1] = root.val + (sonsMaxRes[1]>0?sonsMaxRes[1]:0); //***bug:三目表达式最外层一定要套括号！！
        return curRes;
    }

}
