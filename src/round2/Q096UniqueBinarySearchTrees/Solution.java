/**算法分析：典型dp
 *
 * 状态转移方程：dp[i] = (j=0)Σ(i-1) dp[j]*dp[i-1-j]
 *
 * */

package round2.Q096UniqueBinarySearchTrees;

import java.util.Arrays;

class Solution {

    public int numTrees(int n) {
        if (n<0)
            return 0;

        int[] dp = new int[n+1];
        Arrays.fill(dp, 0);
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }

        return dp[n];
    }
}