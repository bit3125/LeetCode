package leetcode.solutions;

import java.util.Arrays;

/**算法分析：Tn = O(mn)(虽然只是剪枝，但是仔细一想还真是优化了一个次方), Sn = O(mn)
 *
 * 对DFS加入了一个cache矩阵，进行了剪枝优化
 * 讨论区中有的将此法称为DP，其实并不是DP，先前我也考虑过DP，但是DP的状态转移来源有四个方向，根本无法进行DP，
 * 于是这个DP矩阵就可以刚好退化为本解法中的cache矩阵（也算是一种不完全DP吧），DFS过程依然是自顶向下的，
 * 但是每个节点计算过了之后将maxLen存储在cache之中，这样下一次再用到的时候就避免了自顶向下的重复计算，
 * 完成了大面积的剪枝。仔细一想，相当于DP的效果了，复杂度降低了一个数量级。
 *
 * */
public class Q329LongestIncreasingPathinaMatrix_Solution2 {

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0)
            return 0;

        int[][] maxLens = new int[matrix.length][matrix[0].length]; //存储从某节点为起点的最长递增路径长度，因其值至少为1，故若为0则表示未曾计算过
        for (int i = 0; i < matrix.length; i++)
            Arrays.fill(maxLens[i], 0);
        int max = 0;
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                max = Integer.max(max, dfs(matrix, i, j, maxLens));

        return max;
    }

    /**计算(x, y)为起点的最长递增路径长度
     * 入递归之前进行合法性判断，故调用此函数的前提已经默认 (x, y)是合法的
     * return: (i, j)节点为起点的长递增路径长度
     */
    private int[] directX = new int[]{0, 0, 1, -1};
    private int[] directY = new int[]{1, -1, 0, 0};
    private int dfs(int[][] matrix, int x, int y, int[][] maxLens) {
//        if ( false) // 递归出口由于newX newY需要提前做判断，故都整合到dfs的入口处进行判断，此处不设置递归出口
//            return 0;

        //else: in boundary & increasing
        int max = 0; // Can't be set as min_value. See the return value
        int newX, newY;
        for (int i = 0; i < 4; i++) {
            newX = x + directX[i];
            newY = y + directY[i];
            if ( outOfBound(matrix, newX, newY) || matrix[newX][newY]<=matrix[x][y]) //边界控制
                continue;
            max = Integer.max(max, maxLens[newX][newY]==0?
                    ( maxLens[newX][newY]=dfs(matrix, newX, newY, maxLens) ):maxLens[newX][newY]);
        }

        return max+1; //***bug:forget to plus one
    }

    private boolean outOfBound(int[][] matrix, int i, int j) {
        return !(0 <= i && i < matrix.length && 0 <= j && j < matrix[0].length);
    }

}
