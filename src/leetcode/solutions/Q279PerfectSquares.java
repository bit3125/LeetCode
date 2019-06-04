/**算法分析：
 * 计算n的最少平方数数的时候发现有很多重复子问题，使用动态规划
 * 设f[i]为i最少平方数数
 * 状态转移方程: f[i] = max{f[j]+f[i-j], 0<=j<=i/2}
 * 初始条件：f[0]=0;f[k] = 1, k∈{所有<=n的平方数}
 * 
 * Tn = O(n^2)
 * */

package leetcode.solutions;

import java.util.Arrays;

public class Q279PerfectSquares {

    public int numSquares(int n) {
        if (n<=0)
        	return 0;
        
        //init
        int[] f = new int[n+1];
        int curCnt;
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 0;
        	//mark squares
        int iSquare;
        for (int i=1;;i++){
        	iSquare = i*i;
        	if (iSquare>n)
        		break;
        	f[iSquare] = 1;
        }

        //cal
        for (int i=2;i<=n;i++){
        	for (int j=0;j<=i/2;j++){
        		curCnt = f[j]+f[i-j];
        		if (curCnt<f[i])
        			f[i] = curCnt;
        	}
        }
        
        return f[n];
    }
	
	public static void main(String[] args) {
		Q279PerfectSquares q = new Q279PerfectSquares();
		int n = 12;
		System.out.println(q.numSquares(n));
	}

}
