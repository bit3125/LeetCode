/**
 * 状态定义：dp[i][j] : 从最左上点到达(i, j)共有dp种方法
 * 转移方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
 * 初始条件：dp[i][0] = dp[0][j] = 1
 *
 * */
package round2.Q062UniquePaths;

import java.util.Arrays;

class Solution {
    public int uniquePaths(int m, int n) {
        if (m<=0 || n<=0)
            return 0;

        // init
        int[] dp1 = new int[n], dp2 = new int[n], swapTmp;
        Arrays.fill(dp1, 1);

        // dp
        for (int i = 1; i < m; i++) {
            dp2[0] = 1;
            for (int j = 1; j < n; j++)
                dp2[j] = dp1[j] + dp2[j-1];
            swapTmp = dp1;
            dp1 = dp2;
            dp2 = swapTmp;
        }

        return dp1[n-1];
    }
}