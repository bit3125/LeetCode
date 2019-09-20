/**题目：矩阵顺时针旋转90度，用公式
 * 算法分析：
 * 旋转公式 [i][j]->[j][n-1-i]->[n-1-i][n-1-j]->[n-1-j][i]->, 逐圈旋转
 * */

package others.interviewexperience.alibaba;

import java.util.Arrays;

public class Solution {

    public static void rotateMatrix(int[][] mat) {
        if (mat==null || mat.length==0)
            return ;

        int n = mat.length;
        int tmp;
        for (int i = 0; i < n / 2 ; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                tmp = mat[i][j];
                mat[i][j] = mat[n-1-j][i];
                mat[n-1-j][i] = mat[n-1-i][n-1-j];
                mat[n-1-i][n-1-j] = mat[j][n-1-i];
                mat[j][n-1-i] = tmp;
            }
        }
    }

    public static void printMat(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
    }

    public static void main(String[] args) {
//        int[][] mat = new int[][]{{1}};
//        int[][] mat = new int[][]{{1,2},{3,4}};
//        int[][] mat = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
//        int[][] mat = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] mat = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};

        printMat(mat);
        rotateMatrix(mat);
        System.out.println();
        printMat(mat);
    }

}
