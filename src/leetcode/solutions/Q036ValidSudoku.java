/**算法分析 ： Tn = On, Sn = Ok, 其中n为board规模，k为字符种类
 *
 * 使用最简单的BruteForce的话，Tn=O(3*n)=O(n), Sn=O(k)，复杂度都是一样的，
 * 但是使用这里的算法的话，时间上从遍历3次优化到遍历一次。
 * 核心思想是在一次遍历的过程中把ij分别映射到三种约束方法上
 *
 * */

package leetcode.solutions;

import java.util.Arrays;

public class Q036ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board==null || board.length==0)
            return false;

        int[] row = new int[9], column = new int[9], square = new int[9];
        char c;
        for (int i = 0; i < 9; i++) {
            Arrays.fill(row, 0);
            Arrays.fill(column, 0);
            Arrays.fill(square, 0);
            for (int j = 0; j < 9; j++) {
                c = board[i][j];
                if (c!='.'){ //row
                    if (row[c-'1']>=1) return false;
                    row[c-'1']++;
                }
                c = board[j][i];
                if (c!='.'){//column
                    if (column[c-'1']>=1) return false;
                    column[c - '1']++;
                }
                c = board[i/3*3+j/3][i%3*3+j%3]; //nice mapping
                if (c!='.'){//square
                    if (square[c-'1']>=1) return false;
                    square[c - '1']++;
                }
            } //forj
        } //fori

        return true;
    }

}
