package leetcode.solutions;
/* �㷨������
 * �տ�ʼ�õ��Ǹ��Ӷ�O(n^2)����ö�٣�
 * �������Tn = On
 * ������start������ʧ����idx����[[start, idx]�������ܳ�Ϊsuccess_idx
 * 
 * */
public class Q134GasStation {

	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas==null||cost==null||gas.length!=cost.length||gas.length==0)
			return -1;
		int failAt;
		
		for (int i=0;i<cost.length;i++){
			failAt = core(gas, cost, i);
			if (failAt==-1)//success
				return i;
			else {//failed
				if (failAt<i) //***bug: �߹�һ�α�����
					break;
				i = failAt;//***bug:failAt+1
			}
		}
		
		return -1;
	}
	
	/**
	 * return :failed idx if failed, -1 if success
	 * */
	public int core(int[] gas, int[] cost, int start){
		int gasLeft = 0;
		
		for (int i=0;i<cost.length;i++){
			if (start==cost.length)
				start = 0;
			gasLeft += gas[start];
			gasLeft -= cost[start];
			if (gasLeft<0)
				return start;
			start++;
		}
		
		return -1;
	}

	public static void main(String[] args) {
		Q134GasStation q = new Q134GasStation();
//		int[] gas = {1,2,3,4,5};
//		int[] cost = {3,4,5,1,2};
		
//		int[] gas = {5,1,2,3,4};
//		int[] cost = {4,4,1,5,1};
		

		int[] gas = {3,3,4};
		int[] cost = {3,4,4};
		
		
		System.out.println(q.canCompleteCircuit(gas, cost));
		
	}

}
