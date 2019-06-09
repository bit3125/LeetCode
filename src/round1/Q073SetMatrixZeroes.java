package round1;

import java.util.Arrays;

/**�㷨������Tn = O(mn), Sn = O(1)
 * ����0�����0�г��������Ϊmarker��ͬʱʹ�� firstRowMark, firstRowMark ������������ǵ�0�����0�еı�0�����
 * ���ڱ���˳��Ϊ�������´������������ȣ����Կ�������ÿ��marker������������/�еĵ�һ��Ԫ�أ�����ʹ��markerλ
 * �洢ĳ��/�еı�0��Ϣ֮ǰ�������Ѿ���marker��λ�ϵ���Ϣ��ʹ�ù��ˣ��ʲ��������Ϣ��ʧ��
 * ���ֱ�ʹ����������������0��/�н���mark
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
