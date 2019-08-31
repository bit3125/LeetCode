package round2.Q300LongestIncreasingSubsequence;

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums==null || nums.length==0)
            return 0;

        int[] dp = new int[nums.length];
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] >= nums[i])
                    continue;
                dp[i] = Integer.max(dp[i], dp[j]+1);
            }
            maxLen = Integer.max(maxLen, dp[i]);
        }

        return maxLen;
    }
}