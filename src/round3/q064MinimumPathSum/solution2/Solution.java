package round3.q064MinimumPathSum.solution2;

/**
 * 状态定义: dp[i][j]为grid[i][j]到达终点的合规最短路径和
 * 转移方程: dp[i][j] = grid[i][j] + Integer.min(dp[i+1][j], dp[i][j+1]). (dp方向: 从右到左, 从下到上)
 * 边界条件: dp[grid.length-1][j] = grid[grid.length-1][j] + dp[grid.length-1][j+1]
 * dp[i][grid[0].length-1] = grid[i][grid[0].length-1] + dp[i + 1][grid[0].length-1]
 *
 * 更多优化:
 * 1. 从左上到右下的最短路径可转化为从右下到左上的最短路径, 这样dp方向就变正常了, 降低理解成本
 * 2. 转移方程里, 状态的转移只依赖于本行跟上行, 空间复杂度可压缩至On
 */

class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        // init dp
        int[][] dp = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            dp[i] = new int[grid[0].length];
            for (int j = 0; j < grid[0].length; j++) {
                dp[i][j] = 0;
            }
        }

        // bound cases
        dp[grid.length - 1][grid[0].length - 1] = grid[grid.length - 1][grid[0].length - 1];
        for (int i = grid.length - 2; i >= 0; i--) {
            dp[i][grid[0].length - 1] = grid[i][grid[0].length - 1] + dp[i + 1][grid[0].length - 1];
        }
        for (int j = grid[0].length - 2; j >= 0; j--) {
            dp[grid.length - 1][j] = grid[grid.length - 1][j] + dp[grid.length - 1][j + 1];
        }

        // dp
        for (int i = grid.length - 2; i >= 0; i--) {
            for (int j = grid[0].length - 2; j >= 0; j--) {
                dp[i][j] = grid[i][j] + Integer.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }

        return dp[0][0];
    }
}