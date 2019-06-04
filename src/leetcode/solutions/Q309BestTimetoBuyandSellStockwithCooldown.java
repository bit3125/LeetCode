/**Wrong Answer
 * �㷨������
 * ����˼·�ǣ���ȡ�����������е������ڴ�Ϊinterval list��Ȼ����ÿ�������ڵ����Ҷ˵������������
 * ����������cooldown�Ĵ��ڣ������������֮��Ķ˵���д���
 * ���������ڵĶ˵��ϵ�����������
 * 1.���>=2������������½�������������Ϊcooldown������ֱ�������������ڷֱ�����������
 * 2.���==1�����������ǰ�ߵ����һ����ߺ��ߵĵ�һ����Ϊcooldown
 * ��һ��������账���ڶ�����������·�������
 * �ֱ����a[1]��cooldown��b[0]��cooldown�Լ�ֻ��һ�ν��׽�ab����ϲ��������ߵ�������棬ȡ����ߡ�
 * 
 * д���㷨�󣬷��������㷨��û�ܴﵽȫ�����Ž⣬��Ϊֻ�������������䣬û�п��ǵ��������Ĺ�ϵ�������������ӣ�
 * [2,6,8,7,8,7,9,4,1,2,4,5,8]
 * һ��������������[0,2], [3,4], [5,6], [8,12]
 * ���Ž�����ȫ��������[3,4],��������[5,6],
 * �����Ϊ[0,2], [5,6], [8,12]���������15
 * ���������㷨������������⣬
 * ��������㷨��Wrong Answer
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
        while(idx<prices.length-1){//�½��ں󵽴����һ��idx�ˣ�break��Ȼ����ѭ����
        	int startIdx = idx;
        	while(idx<=prices.length-2 && prices[idx]<prices[idx+1]){
        		idx++;
        	}//��ʱiͣ���������ڵ��Ҷ˵���
        	if (startIdx<idx)
        		riseIntervals.add(new int[]{startIdx, idx});
          	while(idx<=prices.length-2 && prices[idx]>=prices[idx+1]){//key:�˴�һ��Ҫȡ��
          		//==�Ľ�����Ҫ�ӳ�ȥ����Ϊ����û�г��еı�Ҫ������������cooldown
        		idx++;
        	}//��ʱiͣ�����½��ڵ��Ҷ˵���
        }
        
        //select cooldown day
        for (int i=0;i<riseIntervals.size()-1;i++){
        	int[] a = riseIntervals.get(i), b = riseIntervals.get(i+1);
        	if (b[0]-a[1]>1)//����������
        		continue;
        	
        	int profitACooldown = prices[b[0]+1]-prices[b[0]];//ѡA��cooldown������
			int profitBCooldown = prices[a[1]]-prices[a[1]-1];//ѡB��cooldown������
			int profitNotSell = prices[b[0]+1]-prices[a[1]-1];//������������
			if (profitACooldown>profitNotSell){
				if (profitACooldown>profitBCooldown){
					a[1]--; //a�����Ҷ˵�����
				}else{
					b[0]++;//b������˵�����
				}
			}else{
				if(profitNotSell>profitBCooldown){
					//ab����ϲ�
					int[] c = {a[0], b[1]};
					riseIntervals.remove(a);
					riseIntervals.remove(b);
					riseIntervals.add(i, c);
					i--;
				}else{
					b[0]++;//b������˵�����
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
