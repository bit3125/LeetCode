package leetcode.solutions;
import java.util.Arrays;

/**思路分析：
 * Tn = max{O(n*logn), O(m*logn)}
 * 
 * 对heaters进行排序   O(n*logn) 
 * 对每个house进行遍历, 查找到其在heaters坐标序列中的位置，即找到离他最近的两个heater O(m)
 * 然后计算两个距离挑出最小的（满足最小的就可以） O(logn)
 * 最终找出能满足每个house的半径大小
 * */
public class Q475Heaters_Solution2 {

    public int findRadius(int[] houses, int[] heaters) {
    	if (houses==null||heaters==null)
    		return -1;
    	
    	int front, rear, mid;
    	int maxDis = Integer.MIN_VALUE; 
//    	Arrays.sort(houses); // house不需要排序
    	Arrays.sort(heaters);
    	
    	// 使用双子列类二分查找
    	for (int house : houses){
    		front = 0;
    		rear = heaters.length-1;
    				
    		while(rear-front>1){ //当==1时会停下
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
    		//停下之后有以下情况：
    		//1.front指向heaters中坐标比house小的子列的最后一位，rear指向heaters中坐标比house大的子列的第一位
    		//2.找到了一个heater与house同一坐标，强行令front与rear指向该heater
    		//3.若targetvalue在总列左侧，则front与rear都指向列首
    		//4.若targetvalue在总列右侧，则front与rear都指向列尾
    		//下方使用abs就是为了对付出现3.4.的情况
    		
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
