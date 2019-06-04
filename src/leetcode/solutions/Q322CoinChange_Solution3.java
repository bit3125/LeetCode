/**算法分析：Tn = O(n*coins.length)。使用完全背包算法，Tn 和  Sn都与Solution2的DP一毛一样
 * 使用完全背包，j从前到后遍历
 * 总体积V：amount
 * 物品体积：coins
 * 物品价值：1
 * 要改动的地方：不求最大价值，求最小价值
 * 
 * */

package leetcode.solutions;

import java.util.Arrays;

public class Q322CoinChange_Solution3 {

	public int coinChange(int[] coins, int amount) {
		if (coins==null || coins.length==0)
			return -1;
		
		//init
		int[] f = new int[amount+1];
		Arrays.fill(f, Integer.MAX_VALUE);
		f[0] = 0;
		
		//dp
		for (int i=0;i<coins.length;i++){
//			for (int j=1;j<coins[i] && j<f.length;j++) //***bug:少了j<f.length
//				f[j] = f[j];
			for (int j=coins[i];j<=amount;j++){
				int fPrev = f[j-coins[i]];
				f[j] = Integer.min(fPrev==Integer.MAX_VALUE?Integer.MAX_VALUE:fPrev+1, f[j]);//***bug: MAX_VALUE+1后溢出了
				//两个转移来源
			}
		}
		
		if (f[f.length-1]==Integer.MAX_VALUE)
			return -1;
		else
			return f[f.length-1];
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
