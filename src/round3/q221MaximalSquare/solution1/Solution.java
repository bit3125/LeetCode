package round3.q221MaximalSquare.solution1;

/**
 * 该解法错误. ban掉. 看Solution2吧
 *
 * 状态定义: dp1[i, j]为以matrix(i,j)为下顶点的线段的最大边长
 * dp2[i, j]为以matrix(i,j)为右顶点的线段的最大边长
 * dp[i, j]为以matrix(i,j)为右下顶点的最大正方形的边长
 * 转移方程:
 * dp1[i, j] = matrix[i, j] * (dp1[i - 1, j] + 1)
 * dp2[i, j] = matrix[i, j] * (dp1[i, j - 1] + 1)
 * dp[i, j] = min(dp1[i, j], dp2[i, j])
 * 边界条件: dp1[0, j] = matrix[0][j];
 *          dp2[i, 0] = matrix[i][0];
 *          dp[0, j] = dp1[0, j];
 *          dp[i, 0] = dp2[i, 0];
 */

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int[][] dp1 = new int[matrix.length][matrix[0].length], dp2 = new int[matrix.length][matrix[0].length];
        int max = 0;
        //***BUG: 两组边界忘记初始化
        //***BUG: max(dp数组的简化)两侧边界忘记初始化
        for (int j = 0; j < matrix[0].length; j++) {
            dp1[0][j] = char2Int(matrix[0][j]);
            max = Integer.max(max, dp1[0][j]);
        }
        for (int i = 0; i < matrix.length; i++) {
            dp2[i][0] = char2Int(matrix[i][0]);
            max = Integer.max(max, dp2[i][0]);
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                dp1[i][j] = char2Int(matrix[i][j]) * (dp1[i - 1][j] + 1);
                dp2[i][j] = char2Int(matrix[i][j]) * (dp2[i][j - 1] + 1);
                max = Integer.max(Integer.min(dp1[i][j], dp2[i][j]), max);
            }
        }

        return max * max;
    }

    public int char2Int(char c) {
        return c - '0';
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
//        char[][] matrix = new char[][]{{'0', '1'}, {'1', '0'}};
//        char[][] matrix = new char[][]{{'1', '1'}, {'1', '1'}};
        char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(sl.maximalSquare(matrix));
    }
}