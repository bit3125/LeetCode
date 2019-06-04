package leetcode.solutions;

/**�㷨������Tn = O((mn)^2), Sn=O1(���Ƶݹ�ջ)
 * ʹ������򵥵�ȫ��DFS��û�м��κμ�֦�Ż�
 * TLE��תSolution2
 *
 * */
public class Q329LongestIncreasingPathinaMatrix_Solution1 {

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0)
            return 0;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                max = Integer.max(max, dfs(matrix, i, j, Integer.MIN_VALUE));

        return max;
    }


    /**
     * return: �Ը��ڵ���˵��(i, j)�ڵ�Ϊ����**��Ч**�����·������
     */
    int[] directX = new int[]{0, 0, 1, -1};
    int[] directY = new int[]{1, -1, 0, 0};
    private int dfs(int[][] matrix, int x, int y, int preValue) {
        if ( outOfBound(matrix, x, y) || matrix[x][y]<=preValue)
            return 0;

        //else: in boundary & increasing
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++)
            max = Integer.max(max, dfs(matrix, x + directX[i], y + directY[i], matrix[x][y]));

        return max+1; //***bug:forget to plus one
    }

    private boolean outOfBound(int[][] matrix, int i, int j) {
        return !(0 <= i && i < matrix.length && 0 <= j && j < matrix[0].length);
    }
}
