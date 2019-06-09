/**算法分析：Tn = O(n*coins.length)
 * 定义状态：f[i]为 达到面值i能使用的最少的硬币数
 * 状态转移方程：f[i] = min{f[i-coins[j]]+1, where 0<=j<coins.length && i-coins[j]>0 && f[i-coins[j]]存在} 
 * ，若其中都不存在则f[i] 也不存在
 * 初始条件：f[k] = 1, where k in coins;
 * 
 * 本题亦可使用完全背包来做
 * */

package round1;

import java.util.Arrays;

public class Q322CoinChange_Solution2 {

	public int coinChange(int[] coins, int amount) {
		if (coins==null || coins.length==0)
			return -1;
		
		//init
		int[] f = new int[amount+1];
		Arrays.fill(f, Integer.MAX_VALUE);
		for (int i=0;i<coins.length;i++){
			if (coins[i]<f.length) //***bug:硬币面值中可能有比amount大的
				f[coins[i]] = 1;
		}
		//f[0]弃置
		
		int curF;
		for (int i=1;i<f.length;i++){ //i表目标面值
			for (int j=0;j<coins.length;j++){ //遍历选出最小值
				if (coins[j]>=i) //==的时候已经init为1了
					continue;
				curF = ( f[i-coins[j]]==Integer.MAX_VALUE?Integer.MAX_VALUE:(f[i-coins[j]]+1) );
					//若i-coins[j]是组不成的数，那么本次组合无效
				if (curF<f[i])
					f[i] = curF;
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
