package round2.Q289GameofLife;

class Solution {
    public void gameOfLife(int[][] board) {
        if (board==null || board.length==0 || board[0].length==0)
            return;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int liveNeighNum = liveNeighborsCur(board, i, j);
                if (getStatus(board, i, j, 1) == 0) { // dead cell
                    if (liveNeighNum == 3)
                        setStatus(board, i, j, 2, 1);
                } else { // live cell
                    if (liveNeighNum < 2 || liveNeighNum > 3)
                        setStatus(board, i, j, 2, 0);
                    else
                        setStatus(board, i, j, 2, 1);
                }
            }
        }
        updateStatus(board);
    }

    private int liveNeighborsCur(int[][] board, int i, int j) {
        if (outOfRange(board, i, j))
            return -1;

        int liveNeighNum = 0;
        for (int k = i-1; k <= i + 1; k++) {
            for (int l = j-1; l <= j + 1; l++) {
                if (outOfRange(board, k, l)) //***bug: if (outOfRange(board, i, j))
                    continue;
                if (k==i && l==j) //***bug: forget
                    continue;
                liveNeighNum += getStatus(board, k, l, 1);
            }
        }

        return liveNeighNum;
    }

    private boolean outOfRange(int[][] board, int i, int j) {
        return !(0 <= i && i < board.length && 0 <= j && j < board[0].length);
    }

    /**
     * (i, j) must be legal
     * @param epoch   1 cur, 2 next
     * */
    private int getStatus(int[][] board, int i, int j, int epoch) {
        int status = board[i][j] & epoch;
        while (status > 1)
            status >>>= 1;
        return status;
    }

    /**
     * (i, j) must be legal
     * @param epoch     same as above
     * @param status    0 dead, 1 alive
     * */
    private void setStatus(int[][] board, int i, int j, int epoch, int status) {
        int mask = ~epoch;

        int cnt = epoch;
        while (cnt > 1) {
            status <<= 1;
            cnt >>>= 1;
        }
        board[i][j] = (board[i][j] & mask) | status;
    }

    /**
     * Update all status to next epoch
     * */
    private void updateStatus(int[][] board) {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                board[i][j] >>>= 1;
    }

}