package round1;

import java.util.Arrays;

/**算法分析：Tn = O(mn), Sn = O(1)
 * 将第0行与第0列抽离出来作为marker，同时使用 firstRowMark, firstRowMark 两个变量来标记第0行与第0列的标0情况。
 * 由于遍历顺序为从上至下从左至右行优先，可以看出来，每个marker都是其所在行/列的第一个元素，故在使用marker位
 * 存储某行/列的标0信息之前，我们已经把marker本位上的信息给使用过了，故不会造成信息丢失。
 * 最后分别使用两个变量单独对0行/列进行mark
 *
 * */
public class Q073SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0)
            return ;

        //mark
        int firstRowMark = 1, firstColumnMark = 1 ;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    if (i==0)
                        firstRowMark = 0;
                    if (j==0)
                        firstColumnMark = 0;
                }
            }
        }

        //set
        for (int i = 1; i < matrix.length; i++)  //row
            for (int j = 1; j < matrix[0].length; j++)
                if ( matrix[i][j]!=0 && ( matrix[i][0]==0 || matrix[0][j]==0) )
                    matrix[i][j] = 0;
        if (firstRowMark==0)
            Arrays.fill(matrix[0], 0);
        if (firstColumnMark == 0)
            for (int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;

    }

}
