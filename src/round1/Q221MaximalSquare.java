/**�㷨������������T(n) = O((mn)^2)��ʹ��DP
 * ״̬���壺f[i][j] Ϊ��matrix[i][j]Ϊ���½ǵ���������εı߳�
 * ״̬ת�Ʒ��̣�f[i][j] = min{f[i-1][j-1], f[i-1][j], f[i][j-1]} + 1
 * ��ʼ������f[i][0] = mat[i][0]
 * 		  f[0][j] = mat[0][j]
 * 
 * ת�Ʒ����Ƶ���
 * f[i][j-1]�����˳���top����right����������α߽磬
 * f[i-1][j]�����˳���left����buttom����������α߽磬
 * f[i-1][j-1]�����˳���buttom����right����������α߽�
 * ��ȡ���ߵ�min+1
 * */

package round1;

import java.util.Arrays;

public class Q221MaximalSquare {

	public int maximalSquare(char[][] matrix) { //***bug:char[][] instead of int[][]
		if (matrix==null || matrix.length==0)
			return 0;
		
		//init
		int m = matrix.length, n = matrix[0].length;
		int[] prevDP = new int[n], curDP = new int[n], tmp;
		for (int i=0;i<prevDP.length;i++)
			prevDP[i] = matrix[0][i]-'0';
		Arrays.fill(curDP, 0);
		
		int maxSize = Integer.MIN_VALUE;
		for (int i=0;i<prevDP.length;i++){
			if (prevDP[i]>maxSize)
				maxSize = prevDP[i];
		}
		
		//dp
		for (int i=1;i<m;i++){ //m-1 times
			//init [0]
			curDP[0] = matrix[i][0]-'0'; 
			if (curDP[0]>maxSize)
				maxSize = curDP[0];
			//cal others
			for (int j=1;j<n;j++){
				if (matrix[i][j]=='0'){
					curDP[j] = 0;
				}else{ //matrix[i][j]=='1'
					curDP[j] = Integer.min( curDP[j-1], Integer.min(prevDP[j-1], prevDP[j]) ) + 1;
					if (curDP[j]>maxSize)
						maxSize = curDP[j];
				}
			}
			//swap
			tmp = prevDP;
			prevDP = curDP;
			curDP = tmp;
		}
		
		return maxSize*maxSize;
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
