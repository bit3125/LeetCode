package round1;
import java.util.Arrays;

/**���㷨���Ӷ�̫�ߣ����TLE
 * ���Ǳ���ÿ��house��heater��������������������Сr
 * MIN MAX Ҫ�ú����
 * Tn = O(m*n) 
 * */
public class Q475Heaters_Solution1 {

    public int findRadius(int[] houses, int[] heaters) {
    	if (houses==null||heaters==null)
    		return -1;
    	
    	return -allCovered(houses, heaters, 0);
    }
    
    public int allCovered(int[] houses, int[] heaters, int r){
    	int res = Integer.MAX_VALUE;
    	for (int house : houses){
    		res = Math.min(res, isCovered(house, heaters, r));
    	}
    	
    	return res;
    }
    
    public int isCovered(int house, int[] heaters, int r){
    	int left, right;//[]
    	int res_left, res_right;
    	int res = Integer.MIN_VALUE; //ԣ��
    	for (int heater : heaters){
    		left = heater-r;
    		right = heater+r;
    		res_left = house-left;
    		res_right = right-house;
			res = Math.max(res, Math.min(house-left, right-house));
    	}
    	
    	return res;
    }
	
	public static void main(String[] args) {
		Q475Heaters_Solution1 q = new Q475Heaters_Solution1();
//		int[] houses = {1,2,3,};
//		int[] heaters = {2,};
		int[] houses = {1,2,3,4};
		int[] heaters = {1,4};
		
		System.out.println(q.findRadius(houses, heaters));
	}

}
