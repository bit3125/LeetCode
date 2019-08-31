/**算法分析：2d-dp
 * 状态定义：dp[i][j] 为 到达点(i, j)的最短路径和
 * 转移方程：dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
 * 边界条件：dp[0][0] = grid[0][0];
 *          dp[0][j] = dp[0][j-1]+grid[0][j], where j>0;
 *          dp[i][0] = dp[i-1][0]+grid[i][0], where i>0;
 * */

package round2.Q064MinimumPathSum;

class Solution {
    public int minPathSum(int[][] grid) {
        if (grid==null || grid.length==0)
            return 0;

        int[] dp1 = new int[grid[0].length], dp2 = new int[grid[0].length];
        dp1[0] = grid[0][0];
        for (int i = 1; i < dp1.length; i++)
            dp1[i] = dp1[i - 1] + grid[0][i];

        for (int i = 1; i < grid.length; i++) {
            dp2[0] = dp1[0] + grid[i][0];
            for (int j = 1; j < grid[0].length; j++)
                dp2[j] = Integer.min(dp1[j], dp2[j-1])  + grid[i][j];

            // swap
            int[] tmp = dp1;
            dp1 = dp2;
            dp2 = tmp;
        }

        return dp1[dp1.length - 1];
    }
}