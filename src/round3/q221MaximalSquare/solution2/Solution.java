package round3.q221MaximalSquare.solution2;

/**
 * �ýⷨ��Ȼ����������. ��Solution3
 *
 * ״̬����: dp[i][j]����Ϊ��matrix[i][j]Ϊ�¶������������α߳�
 *          dp[i, 0] = dp2[i, 0];
 *
 * �߽�����: dp[0][j] = matrix[0][j]
 *          dp[i][0] = matrix[i][0]
 */

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int j = 0; j < matrix[0].length; j++) {
            dp[0][j] = char2Int(matrix[0][j]);
            max = Integer.max(max, dp[0][j]);
        }
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = char2Int(matrix[i][0]);
            max = Integer.max(max, dp[i][0]);
        }

        int dist = 0;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                dist = Integer.min(dp[i - 1][j], dp[i][j - 1]); // ��/�ϵ�λ�õ���������α߳�����Сֵ
                // �ҵ����Ŀ���Ч�߳�
                for (int k = dist; k >= 0; k--) {
                    dist = k;
                    if (char2Int(matrix[i - k][j - k]) == 1) { // ���ҽ����������Ϊ1ʱ������Ч
                        break;
                    }
                }
                dp[i][j] = char2Int(matrix[i][j])/**��λ�õı߳��Ƿ�����Ч��bool����*/ * ( char2Int(matrix[i - dist][j - dist])/**״̬ת�Ƶ����ı߳���bool����*/ * dist + 1 );
                max = Integer.max(max, dp[i][j]);
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