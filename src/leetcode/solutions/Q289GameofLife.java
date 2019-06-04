package leetcode.solutions;

public class Q289GameofLife {

    public void gameOfLife(int[][] board) {
        if (board==null || board.length==0 || board[0].length==0)
            return;

        int cnt;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                cnt = cntAroundLive(board, i, j);
                if (getCurStatus(board, i, j) == 0) {
                    if (cnt == 3)
                        setNextStatus(board, i, j, 1);
                } else { //==1
                    if (cnt < 2 || cnt > 3)
                        setNextStatus(board, i, j, 0);
                    else
                        setNextStatus(board, i, j, 1);
                }
            }
        }

        shiftMat(board);
    }

    public int cntAroundLive(int[][] board, int i, int j) {
        int cnt = 0;
        for (int k = i-1; k < i+2; k++) {
            for (int l = j-1; l < j+2; l++) {
                if (outOfBound(board, k, l))
                    continue;
                if (k==i && l==j)
                    continue;
                cnt += getCurStatus(board, k, l);
            }
        }
        return cnt;
    }

    public int getCurStatus(int[][] board, int i, int j) {
        if (outOfBound(board, i, j))
            return 0;
        return board[i][j]&1;
    }

    public void setNextStatus(int[][] board, int i, int j, int status) {
        if (outOfBound(board, i, j))
            return ;
        board[i][j] |= status<<1;
    }

    public void shiftMat(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] >>>= 1;
            }
        }
    }

    public boolean outOfBound(int[][] board, int i, int j) {
        return !(0 <= i && i < board.length && 0 <= j && j < board[0].length);
    }

}
