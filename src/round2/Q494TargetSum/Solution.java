package round2.Q494TargetSum;

import java.util.Arrays;

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums==null || nums.length==0)
            return 0;

        // init
        int maxRange = 0;
        for (int i = 0; i < nums.length; i++)
            maxRange += nums[i];
        int[] dp1 = new int[maxRange*2+1], dp2 = new int[maxRange*2+1], tmp;
        Arrays.fill(dp1, 0);
        dp1[-nums[0] + maxRange] += 1; //***bug: =出错, 两者可能是同一个值
        dp1[nums[0] + maxRange] += 1;

        // dp
        int realIdx;
        for (int i = 1; i < nums.length; i++) {
            for (int j = -maxRange ; j <= maxRange; j++) {
                realIdx = j + maxRange;
                dp2[realIdx] = ( (realIdx - nums[i] < 0) ? 0 : dp1[realIdx - nums[i]])
                        + ( (realIdx + nums[i] >= dp1.length) ? 0 : dp1[realIdx + nums[i]]);
            }
            // swap
            tmp = dp1;
            dp1 = dp2;
            dp2 = tmp;
        }
        return (-maxRange<=S && S<=maxRange)?dp1[S+maxRange]:0;
    }
}