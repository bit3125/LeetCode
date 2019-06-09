package round1;

import java.util.Arrays;
import java.util.jar.JarEntry;

public class Q200NumberofIslands {

    public int numIslands(char[][] grid) {
        if (grid==null || grid.length==0)
            return 0;

        //init
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++)
            Arrays.fill(visited[i], false);
        int cnt = 0;

        //DFS
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if ( !(visited[i][j] || outOfRange(grid, i, j) || grid[i][j]=='0') ){//***key:进入之前要先用一遍出口条件，这样才能计算cnt
                    cnt++;
                    numIslandsCore(grid, visited, i, j);
                }
            }
        }
        return cnt;
    }

    public void numIslandsCore(char[][] grid, boolean[][] visited, int i, int j) {
        if (outOfRange(grid, i, j) || visited[i][j] || grid[i][j]=='0') //***bug:outOfRange要放在最前面！
                // 否则不进行先短路的话后面可能数组越界！
            return;

        //visit
        visited[i][j] = true;
        //DFS
        numIslandsCore(grid, visited, i + 1, j);
        numIslandsCore(grid, visited, i - 1, j);
        numIslandsCore(grid, visited, i, j+1);
        numIslandsCore(grid, visited, i, j-1);
    }

    public boolean outOfRange(char[][] grid, int i, int j) {
        return !(0 <= i && i < grid.length && 0 <= j && j < grid[0].length);
    }

    public static void main(String[] args) {
        Q200NumberofIslands q = new Q200NumberofIslands();
        String[] strs = new String[]{"11110", "11010", "11000", "00000"};
        char[][] grid = new char[strs.length][strs[0].length()];
        for (int i = 0; i < strs.length; i++) {
            grid[i] = strs[i].toCharArray();
        }
        for (int i = 0; i < grid.length ; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
        System.out.println(q.numIslands(grid));;
    }
}
