package round1;

public class Q378KthSmallestElementinaSortedMatrix_TODO {

    public int kthSmallest(int[][] matrix, int k) {
        if (matrix==null || matrix.length==0)
            return -1;

        int size = 0; //当前左上方形的边长
        int cnt = 1; //当前左上方形的右下顶点在递增序列中的次序
        while (cnt < k) {
            size++;
            cnt = (size+1) * (size+1)+1;
        }
        //size*size>=k
        cnt = (size-1) * (size-1)+1;
        int curNum ;
        int i = 0, j = 0;
        while (i < matrix.length && j < matrix.length-1) {

            if (matrix[i][size] < matrix[size][j]) {
                curNum = matrix[i][size];
                i++;
                cnt++;
            } else {
                curNum = matrix[size][j];
                j++;
                cnt++;
            }
            if (cnt == k)
                return curNum;
        }
        while (i < matrix.length) {
            curNum = matrix[i][size];
            i++;
            cnt++;
            if (cnt == k) return curNum;
        }
        while (j < matrix.length-1) {
            curNum = matrix[size][j];
            j++;
            cnt++;
            if (cnt == k) return curNum;
        }

        return -1;
    }

    public static void main(String[] args) {
        Q378KthSmallestElementinaSortedMatrix_TODO q = new Q378KthSmallestElementinaSortedMatrix_TODO();
        int[][] matrix = new int[][]{{1,3,5},{6,7,12},{11,14,14}};
        System.out.println(q.kthSmallest(matrix,3));;

    }
}
