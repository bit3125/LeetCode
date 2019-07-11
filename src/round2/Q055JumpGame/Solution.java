/**算法分析：Tn = On^2
 * 最优解见R1 Solution2
 *
 * */


package round2.Q055JumpGame;

import java.util.Arrays;

class Solution {
    public boolean canJump(int[] nums) {
        if (nums==null)
            return false;

        boolean[] dp = new boolean[nums.length];
        Arrays.fill(dp, false);
        dp[0] = true;
        int fastestIdx;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (!dp[j])
                    continue;
                fastestIdx = j + nums[j];
                if (fastestIdx >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[dp.length-1];
    }
}