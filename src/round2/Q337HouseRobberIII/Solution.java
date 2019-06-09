package round2.Q337HouseRobberIII;

import structures.TreeNode;

import java.util.Arrays;

class Solution {

    public int rob(TreeNode root) {
        int[] ret = robCore(root);
        return Integer.max(ret[0], ret[1]);
    }

    /**
     * @return : int[2], {maxV-steal the node, maxV-not steal the node}
     * */
    public int[] robCore(TreeNode root) {
        if (root==null)
            return new int[]{0, 0};

        int[] leftRet = robCore(root.left), rightRet = robCore(root.right);
        int[] ret = new int[2];
        ret[0] = leftRet[1] + rightRet[1] + root.val;
        ret[1] = Integer.max(Integer.max(leftRet[0]+rightRet[0], leftRet[1] + rightRet[1]), //***but: forget [1][1]
                Integer.max(leftRet[0]+rightRet[1], leftRet[1]+rightRet[0]));

        System.out.println(Arrays.toString(ret));
        return ret;
    }

}