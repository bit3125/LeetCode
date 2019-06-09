package round1;

/**算法分析：Tn = O(nlog(MAX-MIN)), Sn = O1
 * 使用基于range的二分搜索
 * 将range分为两个部分，前半为排位小于等于k的数，后半为排位大于k的数
 * 使用第二种二分搜索法：即front永远指向第一段，rear永远指向第二段，最后跳出while条件为（rear-front>1）的之后front即为所求
 *
 * */
public class Q378KthSmallestElementinaSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0 || k<=0)
            return -1;
        int front = matrix[0][0]-1; //***注意-1+1很有讲究
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
