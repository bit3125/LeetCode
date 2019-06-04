/**Wrong Answer
 * 算法分析：
 * 大体思路是，提取出序列中所有的上升期存为interval list，然后在每个上升期的左右端点进行买入卖出
 * 但是由于有cooldown的存在，必须对上升期之间的端点进行处理：
 * 两个上升期的端点关系有两种情况：
 * 1.间距>=2，则这俩间的下降期足以用于做为cooldown，可以直接在两次上升期分别做两次买卖
 * 2.间距==1，则必须挑出前者的最后一天或者后者的第一天作为cooldown
 * 第一种情况无需处理，第二种情况用以下方法处理：
 * 分别计算a[1]做cooldown、b[0]做cooldown以及只做一次交易将ab区间合并，这三者的相对收益，取最大者。
 * 
 * 写完算法后，发现这种算法并没能达到全局最优解，因为只考虑了两两区间，没有考虑到多个区间的关系，比如以下例子：
 * [2,6,8,7,8,7,9,4,1,2,4,5,8]
 * 一共有三个上升期[0,2], [3,4], [5,6], [8,12]
 * 最优解是完全牺牲区间[3,4],保留区间[5,6],
 * 最后结果为[0,2], [5,6], [8,12]，最大收益15
 * 但是这种算法就做不出这个解，
 * 所以这个算法是Wrong Answer
 * */

package leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import leetcode.structures.Interval;

public class Q309BestTimetoBuyandSellStockwithCooldown {

    public int maxProfit(int[] prices) {
        if (prices==null||prices.length==0)
        	return 0;
        
        List<int[]> riseIntervals = new ArrayList<>();
        int idx = 0;
        //search for rising intervals
        while(idx<prices.length-1){//下降期后到达最后一个idx了，break不然就死循环了
        	int startIdx = idx;
        	while(idx<=prices.length-2 && prices[idx]<prices[idx+1]){
        		idx++;
        	}//此时i停留在上升期的右端点上
        	if (startIdx<idx)
        		riseIntervals.add(new int[]{startIdx, idx});
          	while(idx<=prices.length-2 && prices[idx]>=prices[idx+1]){//key:此处一定要取等
          		//==的交易日要扔出去，因为根本没有持有的必要，还能用来做cooldown
        		idx++;
        	}//此时i停留在下降期的右端点上
        }
        
        //select cooldown day
        for (int i=0;i<riseIntervals.size()-1;i++){
        	int[] a = riseIntervals.get(i), b = riseIntervals.get(i+1);
        	if (b[0]-a[1]>1)//区间间隔够大
        		continue;
        	
        	int profitACooldown = prices[b[0]+1]-prices[b[0]];//选A做cooldown的收益
			int profitBCooldown = prices[a[1]]-prices[a[1]-1];//选B做cooldown的收益
			int profitNotSell = prices[b[0]+1]-prices[a[1]-1];//不买卖的收益
			if (profitACooldown>profitNotSell){
				if (profitACooldown>profitBCooldown){
					a[1]--; //a区间右端点左移
				}else{
					b[0]++;//b区间左端点右移
				}
			}else{
				if(profitNotSell>profitBCooldown){
					//ab区间合并
					int[] c = {a[0], b[1]};
					riseIntervals.remove(a);
					riseIntervals.remove(b);
					riseIntervals.add(i, c);
					i--;
				}else{
					b[0]++;//b区间左端点右移
				}
			}
			
        }
        
        //cal profit
        int profit = 0;
        for (int i=0;i<riseIntervals.size();i++){
        	int[] interval = riseIntervals.get(i);
        	profit += prices[interval[1]] - prices[interval[0]];
        }
        
    	return profit;
    }
	
	public static void main(String[] args) {
		Q309BestTimetoBuyandSellStockwithCooldown q = new Q309BestTimetoBuyandSellStockwithCooldown();
		int[] prices = {3,2,6,5,0,3};
//		int[] prices = {6,1,3,2,4,7};
//		int[] prices = {1,2,3,0,2};
		
		System.out.println(q.maxProfit(prices));
	}

}
