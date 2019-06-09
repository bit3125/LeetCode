package round1;

/**�㷨������Tn = O(nlog(MAX-MIN)), Sn = O1
 * ʹ�û���range�Ķ�������
 * ��range��Ϊ�������֣�ǰ��Ϊ��λС�ڵ���k���������Ϊ��λ����k����
 * ʹ�õڶ��ֶ�������������front��Զָ���һ�Σ�rear��Զָ��ڶ��Σ��������while����Ϊ��rear-front>1����֮��front��Ϊ����
 *
 * */
public class Q378KthSmallestElementinaSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0 || k<=0)
            return -1;
        int front = matrix[0][0]-1; //***ע��-1+1���н���
        int rear = matrix[matrix.length - 1][matrix[0].length - 1]+1;
        int mid, cntLessThan;
        while (rear-front>1) {
            mid = (int) ((0L+front+rear)/2); //***bug:overflow
            cntLessThan = cnt(matrix, mid);
            if (cntLessThan + 1 <= k) {
                front = mid;
            } else { // cntLessThan+1 > k
                rear = mid;
            }
        }
        return front;
    }

    private int cnt(int[][] matrix, int mid) {
        int cntLessThan = 0;
        int j = matrix[0].length-1;
        for (int i = 0; i < matrix.length; i++) {
            while (j >= 0 && matrix[i][j] >= mid)
                j--;
            cntLessThan += j + 1;
        }
        return cntLessThan;
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
//        int k = 8;
//        int[][] matrix = new int[][]{{2000000000}};
//        int k = 1;
//        int[][] matrix = new int[][]{{-5}};
//        int k = 1;
        int[][] matrix = new int[][]{{1, 2}, {1, 3}};
        int k = 2;
        Q378KthSmallestElementinaSortedMatrix q = new Q378KthSmallestElementinaSortedMatrix();
        System.out.println(q.kthSmallest(matrix, k));
    }

}
