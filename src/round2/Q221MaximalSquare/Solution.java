/**算法分析
 * 状态定义：dp[i][j] 为以(i, j) 为右下顶点的正方形最大边长
 * 转移方程：dp[i][j] = matrix[i][j]==0?0:(min{dp[i][j-1], dp[i-1][j], dp[i-1][j-1]}+1)
 * 初始条件：dp[i][j] = matrix[i][j], where i==0 || j==0
 * */

package round2.Q221MaximalSquare;

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0)
            return 0;

        int[] dp1 = new int[matrix[0].length], dp2 = new int[matrix[0].length], dp3;
        int maxSize = 0;
        for (int i = 0; i < dp1.length; i++) {
            dp1[i] = matrix[0][i] - '0';
            maxSize = Integer.max(maxSize, dp1[i]);
        }

        for (int i = 1; i < matrix.length; i++) {
            dp2[0] = matrix[i][0] - '0';
            maxSize = Integer.max(maxSize, dp2[0]);
            for (int j = 1; j < matrix[0].length; j++) {
                dp2[j] = matrix[i][j] == '0' ? 0 : (Integer.min(Integer.min(dp1[j], dp2[j - 1]), dp1[j - 1]) + 1);
                maxSize = Integer.max(maxSize, dp2[j]);
            }

            // swap
            dp3 = dp1;
            dp1 = dp2;
            dp2 = dp3;
        }

        return maxSize*maxSize;
    }
}