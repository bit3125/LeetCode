package round2.Q279PerfectSquares;

import java.util.Arrays;

class Solution {
    public int numSquares(int n) {
        if (n<=0)
            return 0;

        // init
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int base = 1;
        while (base * base < dp.length) {
            dp[base*base] = 1;
            base++;
        }
        dp[0] = 0;

        int minNum, curNum;
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] == 1) { //¼ôÖ¦
                continue;
            }
            minNum = Integer.MAX_VALUE;
            for (int j = 0; j <= i/2; j++) {
                curNum = dp[j] + dp[i-j];
                minNum = Integer.min(minNum, curNum);
            }
            dp[i] = minNum;
        }
//        System.out.println(Arrays.toString(dp));
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int n = 12;
        Solution sl = new Solution();
        System.out.println(sl.numSquares(n));
    }
}