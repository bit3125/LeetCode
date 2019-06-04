package leetcode.solutions;
import java.util.Arrays;

/**˼·������
 * Tn = max{O(n*logn), O(m*logn)}
 * 
 * ��heaters��������   O(n*logn) 
 * ��ÿ��house���б���, ���ҵ�����heaters���������е�λ�ã����ҵ��������������heater O(m)
 * Ȼ�������������������С�ģ�������С�ľͿ��ԣ� O(logn)
 * �����ҳ�������ÿ��house�İ뾶��С
 * */
public class Q475Heaters_Solution2 {

    public int findRadius(int[] houses, int[] heaters) {
    	if (houses==null||heaters==null)
    		return -1;
    	
    	int front, rear, mid;
    	int maxDis = Integer.MIN_VALUE; 
//    	Arrays.sort(houses); // house����Ҫ����
    	Arrays.sort(heaters);
    	
    	// ʹ��˫��������ֲ���
    	for (int house : houses){
    		front = 0;
    		rear = heaters.length-1;
    				
    		while(rear-front>1){ //��==1ʱ��ͣ��
    			mid = (front+rear)/2;
    			if (house<heaters[mid])
    				rear = mid;
    			else if (heaters[mid]<house)
    				front = mid;
    			else{//heaters[mid]==house
    				front = mid;
    				rear = mid;
    				break;
    			}
    		}
    		//ͣ��֮�������������
    		//1.frontָ��heaters�������houseС�����е����һλ��rearָ��heaters�������house������еĵ�һλ
    		//2.�ҵ���һ��heater��houseͬһ���꣬ǿ����front��rearָ���heater
    		//3.��targetvalue��������࣬��front��rear��ָ������
    		//4.��targetvalue�������Ҳ࣬��front��rear��ָ����β
    		//�·�ʹ��abs����Ϊ�˶Ը�����3.4.�����
    		
    		maxDis = Math.max(maxDis, Math.min(Math.abs(house-heaters[front]), Math.abs(heaters[rear]-house)));
    	}
    	
    	return maxDis;
    }
	
	public static void main(String[] args) {
		Q475Heaters_Solution2 q = new Q475Heaters_Solution2();
//		int[] houses = {1,2,3,};
//		int[] heaters = {2,};
		int[] houses = {1,2,3,};
		int[] heaters = {1,2,3};
//		int[] houses = {1,2,3,4};
//		int[] heaters = {1,4};
		
		
		System.out.println(q.findRadius(houses, heaters));
	}

}
