/**算法分析：WA
 * 这里信了很早之前看的一篇博文的鬼，使用了贪心算法，是错误的
 * 我们知道，贪心是有条件的，在本题中贪心策略的前提非常简单，即大额硬币必须是所有面值小于它的硬币的面值倍数。
 * 故只能使用多重背包DP求解！ 
 * */

package leetcode.solutions;

import java.util.Arrays;

public class Q322CoinChange_Solution1 {

    public int coinChange(int[] coins, int amount) {
        if (coins==null || coins.length==0)
        	return -1;
        
        int[] cnts = new int[coins.length];
        Arrays.sort(coins);
        reverse(coins);
        
        
        System.out.println(Arrays.toString(coins));
        
        Arrays.fill(cnts, 0);
        
        return coinChangeCore(coins, cnts, amount, 0);
    }
    
    boolean hasFound = false;
    public int coinChangeCore(int[] coins, int[] cnts, int target, int idx){
    	if (hasFound)
    		return -1;
    	
    	if (idx==coins.length){
    		if (target==0){
    			
    			System.out.println(Arrays.toString(cnts));
    			
    			hasFound = true;
	        	int cnt = 0;
	        	for (int i=0;i<cnts.length;i++)
	        		cnt += cnts[i];
    			
    			return cnt;
    		}else //***bug
    			return -1;
    	}
    	
    	for (cnts[idx] = target/coins[idx];cnts[idx]>=0;cnts[idx]--){
    		int cnt = coinChangeCore(coins, cnts, target-coins[idx]*cnts[idx], idx+1);
    		if (cnt!=-1)
    			return cnt;
    	}
    	cnts[idx] = 0; //为了抵消其作为迭代器最后变成的-1
    	return -1;
    }
	
    public void reverse(int[] data){
    	int front = 0, rear = data.length-1;
    	int tmp;
    	while(front<rear){
    		tmp = data[front];
    		data[front] = data[rear];
    		data[rear] = tmp;
    		
    		front++;
    		rear--;
    	}
    }
    
	public static void main(String[] args) {
		Q322CoinChange_Solution1 q = new Q322CoinChange_Solution1();
		int[] coins = {186,419,83,408};
		int amount = 6249;
		
		q.coinChange(coins, amount);
	}

}
