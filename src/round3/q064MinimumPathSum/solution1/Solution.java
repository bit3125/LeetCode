package round3.q064MinimumPathSum.solution1;

/**
 * 错误的. dfs大量重复搜索. 超时
 * 考虑dp
 *
 * */

class Solution {
    int minSum;

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        boolean[][] visited = new boolean[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            visited[i] = new boolean[grid[0].length];
            for (int j = 0; j < grid[0].length; j++) {
                visited[i][j] = false;
            }
        }

        minSum = Integer.MAX_VALUE;
        core(grid, visited, 0, 0, 0);

        return minSum;
    }

    public void core(int[][] grid, boolean[][] visited, int i, int j, int sum) {
        if (!inRange(grid, i, j) || visited[i][j]) {
            return;
        }

        // visit
        sum += grid[i][j];
        visited[i][j] = true;
        if (arrive(grid, i, j)) {
            minSum = Integer.min(sum, minSum);
            visited[i][j] = false;
            return;
        }

        core(grid, visited, i + 1, j, sum);
        core(grid, visited, i, j + 1, sum);
        visited[i][j] = false;
    }

    public boolean inRange(int[][] grid, int i, int j) {
        return 0 <= i && i < grid.length && 0 <= j && j < grid[0].length;
    }

    public boolean arrive(int[][] grid, int i, int j) {
        return i == grid.length - 1 && j == grid[0].length - 1;
    }
}