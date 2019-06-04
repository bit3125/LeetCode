package leetcode.solutions;

import java.util.Arrays;

/**算法分析：本质为寻找“最长递增子序列”，Tn = On^2, Sn = On。没有达到本题On,O1的要求
 * 状态定义：dp[i]为以nums[i]结尾的最长递增子序列的长度
 * 状态转移方程：dp[i] = max{dp[j]+1, 1}, where 0<=j<i && nums[j]<nums[i]
 *
 * */
public class Q334IncreasingTripletSubsequence_Solution1 {

    public boolean increasingTriplet(int[] nums) {
        if (nums==null || nums.length<3)
            return false;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) { //cal dp[i]
            for (int j = 0; j < i; j++) { //traverse dp[0]~dp[i]
                if (nums[j] < nums[i])
                    dp[i] = Integer.max(dp[i], dp[j] + 1);
                if (dp[i]>=3)
                    return true;
            }
        }

        return false;
    }

}
