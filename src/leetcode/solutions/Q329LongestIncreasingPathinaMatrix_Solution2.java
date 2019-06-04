package leetcode.solutions;

import java.util.Arrays;

/**�㷨������Tn = O(mn)(��Ȼֻ�Ǽ�֦��������ϸһ�뻹�����Ż���һ���η�), Sn = O(mn)
 *
 * ��DFS������һ��cache���󣬽����˼�֦�Ż�
 * ���������еĽ��˷���ΪDP����ʵ������DP����ǰ��Ҳ���ǹ�DP������DP��״̬ת����Դ���ĸ����򣬸����޷�����DP��
 * �������DP����Ϳ��Ըպ��˻�Ϊ���ⷨ�е�cache����Ҳ����һ�ֲ���ȫDP�ɣ���DFS������Ȼ���Զ����µģ�
 * ����ÿ���ڵ�������֮��maxLen�洢��cache֮�У�������һ�����õ���ʱ��ͱ������Զ����µ��ظ����㣬
 * ����˴�����ļ�֦����ϸһ�룬�൱��DP��Ч���ˣ����ӶȽ�����һ����������
 *
 * */
public class Q329LongestIncreasingPathinaMatrix_Solution2 {

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0)
            return 0;

        int[][] maxLens = new int[matrix.length][matrix[0].length]; //�洢��ĳ�ڵ�Ϊ���������·�����ȣ�����ֵ����Ϊ1������Ϊ0���ʾδ�������
        for (int i = 0; i < matrix.length; i++)
            Arrays.fill(maxLens[i], 0);
        int max = 0;
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                max = Integer.max(max, dfs(matrix, i, j, maxLens));

        return max;
    }

    /**����(x, y)Ϊ���������·������
     * ��ݹ�֮ǰ���кϷ����жϣ��ʵ��ô˺�����ǰ���Ѿ�Ĭ�� (x, y)�ǺϷ���
     * return: (i, j)�ڵ�Ϊ���ĳ�����·������
     */
    private int[] directX = new int[]{0, 0, 1, -1};
    private int[] directY = new int[]{1, -1, 0, 0};
    private int dfs(int[][] matrix, int x, int y, int[][] maxLens) {
//        if ( false) // �ݹ��������newX newY��Ҫ��ǰ���жϣ��ʶ����ϵ�dfs����ڴ������жϣ��˴������õݹ����
//            return 0;

        //else: in boundary & increasing
        int max = 0; // Can't be set as min_value. See the return value
        int newX, newY;
        for (int i = 0; i < 4; i++) {
            newX = x + directX[i];
            newY = y + directY[i];
            if ( outOfBound(matrix, newX, newY) || matrix[newX][newY]<=matrix[x][y]) //�߽����
                continue;
            max = Integer.max(max, maxLens[newX][newY]==0?
                    ( maxLens[newX][newY]=dfs(matrix, newX, newY, maxLens) ):maxLens[newX][newY]);
        }

        return max+1; //***bug:forget to plus one
    }

    private boolean outOfBound(int[][] matrix, int i, int j) {
        return !(0 <= i && i < matrix.length && 0 <= j && j < matrix[0].length);
    }

}
