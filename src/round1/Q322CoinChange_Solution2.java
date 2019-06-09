/**�㷨������Tn = O(n*coins.length)
 * ����״̬��f[i]Ϊ �ﵽ��ֵi��ʹ�õ����ٵ�Ӳ����
 * ״̬ת�Ʒ��̣�f[i] = min{f[i-coins[j]]+1, where 0<=j<coins.length && i-coins[j]>0 && f[i-coins[j]]����} 
 * �������ж���������f[i] Ҳ������
 * ��ʼ������f[k] = 1, where k in coins;
 * 
 * �������ʹ����ȫ��������
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
			if (coins[i]<f.length) //***bug:Ӳ����ֵ�п����б�amount���
				f[coins[i]] = 1;
		}
		//f[0]����
		
		int curF;
		for (int i=1;i<f.length;i++){ //i��Ŀ����ֵ
			for (int j=0;j<coins.length;j++){ //����ѡ����Сֵ
				if (coins[j]>=i) //==��ʱ���Ѿ�initΪ1��
					continue;
				curF = ( f[i-coins[j]]==Integer.MAX_VALUE?Integer.MAX_VALUE:(f[i-coins[j]]+1) );
					//��i-coins[j]���鲻�ɵ�������ô���������Ч
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
		// TODO �Զ����ɵķ������

	}

}
