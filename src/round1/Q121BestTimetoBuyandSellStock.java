package round1;
/**�㷨������
 * ����ָoffer�ϵĹ�Ʊ��һëһ��
 * �����Ƕ�̬�滮
 * �ɼ򻯳����µ��㷨�������루ʡ�Ե��������������飬һ��f��һ��maxProfits��
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
		// TODO �Զ����ɵķ������

	}

}
