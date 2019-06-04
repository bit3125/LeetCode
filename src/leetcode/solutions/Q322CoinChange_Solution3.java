/**�㷨������Tn = O(n*coins.length)��ʹ����ȫ�����㷨��Tn ��  Sn����Solution2��DPһëһ��
 * ʹ����ȫ������j��ǰ�������
 * �����V��amount
 * ��Ʒ�����coins
 * ��Ʒ��ֵ��1
 * Ҫ�Ķ��ĵط�����������ֵ������С��ֵ
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
//			for (int j=1;j<coins[i] && j<f.length;j++) //***bug:����j<f.length
//				f[j] = f[j];
			for (int j=coins[i];j<=amount;j++){
				int fPrev = f[j-coins[i]];
				f[j] = Integer.min(fPrev==Integer.MAX_VALUE?Integer.MAX_VALUE:fPrev+1, f[j]);//***bug: MAX_VALUE+1�������
				//����ת����Դ
			}
		}
		
		if (f[f.length-1]==Integer.MAX_VALUE)
			return -1;
		else
			return f[f.length-1];
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
