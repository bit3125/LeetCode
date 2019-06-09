/**算法分析：同《offer》中的《礼物的最大值》
 * 状态转移方程：f[i][j] = g[i][j-1]*f[i][j-1] + g[i-1][j]*f[i-1][j]
 * */
package round1;

import java.util.Arrays;

public class Q062UniquePaths {

    public int uniquePaths(int m, int n) {
        if (m<=0 || n<=0)
        	return 0;
        
        int[] prev = new int[n], cur = new int[n];
        int[] tmp;
        Arrays.fill(prev, 1);
        for (int i=1;i<m;i++){ //m-1 times
        	for (int j=0;j<n;j++)
        		cur[j] = (g(j-1)?cur[j-1]:0) + (g(j)?prev[j]:0); //***bug:三目表达式要用括号括起来
        	
        	//swap
        	tmp = prev;
        	prev = cur;
        	cur = tmp;
        }
        
        return prev[prev.length-1];
    }
	
    public boolean g(int j){
    	return 0<=j;
    }
    
	public static void main(String[] args) {
		int m = 3;
		int n = 2;
		Q062UniquePaths q = new Q062UniquePaths();
		System.out.println(q.uniquePaths(m, n));
	}

}
