/**�㷨���� �� Tn = On, Sn = Ok, ����nΪboard��ģ��kΪ�ַ�����
 *
 * ʹ����򵥵�BruteForce�Ļ���Tn=O(3*n)=O(n), Sn=O(k)�����Ӷȶ���һ���ģ�
 * ����ʹ��������㷨�Ļ���ʱ���ϴӱ���3���Ż�������һ�Ρ�
 * ����˼������һ�α����Ĺ����а�ij�ֱ�ӳ�䵽����Լ��������
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
