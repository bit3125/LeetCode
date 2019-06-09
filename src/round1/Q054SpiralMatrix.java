package round1;

import java.util.ArrayList;
import java.util.List;

/**��ָofferԭ�⣺˳ʱ���ӡ����
 * ע��㣺ÿ���while������Ҫ�����Ƿ�break���жϣ������ڷǷ����������bug
 *
 * */

public class Q054SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix==null || matrix.length==0)
            return result;

        int leftBound = 0, rightBound = matrix[0].length-1; //inclusive
        int topBound = 0, buttomBound = matrix.length-1;
        int i = 0, j = -1;
        int n = matrix.length * matrix[0].length;
        while (true) {
            while (j < rightBound) {
                j++;
                result.add(matrix[i][j]);
            }
            topBound++;
            if (result.size()==n) break;
            while (i < buttomBound) {
                i++;
                result.add(matrix[i][j]);
            }
            rightBound--;
            if (result.size()==n) break;
            while (leftBound < j) {
                j--;
                result.add(matrix[i][j]);
            }
            buttomBound--;
            if (result.size()==n) break;
            while (topBound < i) {
                i--;
                result.add(matrix[i][j]);
            }
            leftBound++;
            if (result.size()==n) break;
        }

        return result;
    }

}
