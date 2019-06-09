package round1;
/**算法分析：
 * 跟剑指offer上的股票题一毛一样
 * 本质是动态规划
 * 可简化成以下的算法：见代码（省略掉了两个辅助数组，一个f，一个maxProfits）
 * 
 * */

public class Q121BestTimetoBuyandSellStock {

    public int maxProfit(int[] prices) {
        if (prices==null||prices.length==0)
        	return 0;
        
        int maxProfit =Integer.MIN_VALUE;
        int curProfit ;
        int minIdx = 0;
        for (int i=0;i<prices.length;i++){
        	curProfit = prices[i]-prices[minIdx];
        	if (curProfit>maxProfit)
        		maxProfit = curProfit;
        	
        	if (prices[i]<prices[minIdx])
        		minIdx = i;
        }
        
        return maxProfit;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
