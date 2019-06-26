package round2.Q079WordSearch;

import java.util.Arrays;

class Solution {

    private boolean hasFound;

    public boolean exist(char[][] board, String word) {
        if (board==null || board.length==0 || board[0].length==0 || word==null)
            return false;
        if (word.length()==0)
            return false;

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < visited.length; i++)
            Arrays.fill(visited[i], false);

        hasFound = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, word, visited, i, j, 0);
            }
        }

        return hasFound;
    }

    private void dfs(char[][] board, String word, boolean[][] visited, int i, int j, int curIdx) {
        if (hasFound)
            return;
        if (curIdx == word.length()) {
            hasFound = true;
            return;
        }
        if (outOfRange(board, i, j) || visited[i][j] || board[i][j]!=word.charAt(curIdx)) {
            return;
        }

        // else: word.CharAt(curIdx)==board[i][j]
        visited[i][j] = true;
        curIdx++;
        dfs(board, word, visited, i+1, j, curIdx);
        dfs(board, word, visited, i-1, j, curIdx);
        dfs(board, word, visited, i, j+1, curIdx);
        dfs(board, word, visited, i, j-1, curIdx);
        visited[i][j] = false;
        // i, j, curIdx 全是局部变量，无需回溯
    }

    private boolean outOfRange(char[][] board, int i, int j) {
        return !(0 <= i && i < board.length && 0 <= j && j < board[0].length);
    }
}