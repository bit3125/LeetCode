/**
 * round1.Solution2д�ıȽϺã����Ǹ�
 * */

package round2.Q329LongestIncreasingPathinaMatrix;

import java.util.Arrays;

class Solution {

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0)
            return 0;

        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < cache.length; i++)
            Arrays.fill(cache[i], Integer.MIN_VALUE); // use MIN_VALUE to represent the uncaled status

        int maxLen = Integer.MIN_VALUE, curLen;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                curLen = longestIncreasingPathCore(matrix, cache, i, j, Integer.MIN_VALUE); // prevValue=minvalue, bug maybe
                    // ����ʹ��Integer.MIN_VALUE��Ϊ��һ��prevֵ�Ǵ���©���ģ�����취����core����
                    // ���ں���ͷ��������жϣ�������жϷ���core�ڲ��ĵݹ����֮ǰ�������Ļ��Ͳ���ҪprevValue��
                    // ����������������״ε���ʱ��©��
                maxLen = Integer.max(curLen, maxLen);
            }
        }

        return maxLen;
    }

    int[] iSteps = new int[]{1, -1, 0, 0}, jSteps = new int[]{0, 0, 1, -1};
    /**
     * @return : maxLen of increasing path starting with [i, j]
     * */
    private int longestIncreasingPathCore(int[][] matrix, int[][] cache, int i, int j, int prevValue) {
        if (outOfRange(matrix, i, j) || prevValue >= matrix[i][j] )
            return 0; // illegal, subLen=0
        if (cache[i][j]!=Integer.MIN_VALUE) // cached
            return cache[i][j];

        // else: cal
        int maxLen = 1, curLen; //maxLen initet to 1, [i, j] itself
        for (int k = 0; k < 4; k++) {
            curLen = longestIncreasingPathCore(matrix, cache, i + iSteps[k], j + jSteps[k], matrix[i][j]) + 1;
            if (curLen > maxLen) {
                maxLen = curLen ;
            }
        }
        cache[i][j] = maxLen;
        return maxLen;
    }

    private boolean outOfRange(int[][] matrix, int i, int j) {
        return !(0 <= i && i < matrix.length && 0 <= j && j < matrix[0].length);
    }
}