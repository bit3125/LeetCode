/**�㷨������DP
 * ״̬��f[i][j]Ϊ��(0,0)��(i,j)�ܴﵽ����С��ֵ
 * ״̬ת�Ʒ��̣� f[i][j] = min{f[i-1][j]*g[i-1][j],f[i][j-1]*g[i][j-1] }+weight[i][j]
 * ,���� g[i][j] = 1 if 0<=i&&0<=j else 0;
 * ��ʼ����: f[0][0]=weight[0][0],  
 * */

package leetcode.solutions;

public class Q064MinimumPathSum {

	public int minPathSum(int[][] grid) {
		if (grid==null || grid.length==0)
			return Integer.MAX_VALUE;
		
		//init
		int[] prev = new int[grid[0].length];
		int[] cur = new int[grid[0].length];
		prev[0] = grid[0][0];
		for (int i=1;i<prev.length;i++)
			prev[i] = prev[i-1] + grid[0][i];
		
		//dp
		int[] tmp;
		for (int i=1;i<grid.length;i++){ //grid.length-1 times
			for (int j=0;j<prev.length;j++)
				cur[j] = Integer.min(g(i, j-1)?cur[j-1]:Integer.MAX_VALUE, prev[j])+grid[i][j];
			//swap
			tmp = cur;
			cur = prev;
			prev = tmp;
		}
		
		return prev[prev.length-1];
	}
	
	public boolean g(int i, int j){
		return 0<=i && 0<=j; 
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
