package leetcode.solutions;

import sun.security.x509.AVA;

public class Q289GameofLife_deprecated {

    public void gameOfLife(int[][] board) {
        if (board==null || board.length==0 || board[0].length==0)
            return;

        //init aroundMat
        int[][] aroundMat = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                aroundMat[i][j] = getValue(board, i-1, j-1);
            }
        }

        //update board : from left to right, from top to bottom, column first
        int alive;
        for (int j = 0; j < board[0].length; j++) { //列优先
            for (int i = 0; i < board.length; i++) {
                updateAroundMat(board, aroundMat, i, j);
                alive = cntAroundAlive(aroundMat);
                if (board[i][j] == 0) {
                    if (alive == 3)
                        board[i][j] = 1;
                } else{ //board[i][j] == 1
                    if (alive < 2 || alive > 3)
                        board[i][j] = 0;
                    //else:keep 1
                }
            }
        }

    }

    public int[][] updateAroundMat(int[][] board, int[][] aroundMat, int i, int j) {
        if (i==0 && j==0) //起点不更新
            return aroundMat;

        aroundMat[0] = aroundMat[1];
        aroundMat[1] = aroundMat[2];
        aroundMat[2] = new int[3];
        aroundMat[2][0] = getValue(board, i + 1, j - 1);
        aroundMat[2][1] = getValue(board, i + 1, j);
        aroundMat[2][2] = getValue(board, i + 1, j + 1);

        return aroundMat;
    }

    public int getValue(int[][] board, int i, int j) {
        if ( !(0<=i && i<board.length && 0<=j && j<board[0].length) )
            return 0;
        return board[i][j];
    }

    public int cntAroundAlive(int[][] aroundMat) {
        int cnt = 0;
        for (int i = 0; i < aroundMat.length; i++) {
            for (int j = 0; j < aroundMat.length; j++) {
                cnt += aroundMat[i][j];
            }
        }
        return cnt;
    }

}
