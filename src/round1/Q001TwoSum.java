package round1;
/**题意为，
 * 1.无序
 * 2.可能有重复数字
 * 3.不能使用同一个下标两次
 * 由于1.，不能控制在Tn=On Sn=O1；由于2. 不能使用Hash表来控制在Tn=On Sn=On
 * 
 * */
import java.util.Arrays;
public class Q001TwoSum {

    public int[] twoSum(int[] nums, int target) {
    	if (nums==null || nums.length==0)
    		return null;
    	
    	int[] result = new int[2];
    	int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int front = 0, rear = nums.length-1;
        int sum;
        while(front<rear){
        	sum = copy[front]+copy[rear]; 
        	if (sum==target){
        		result[0] = indexOf(nums, copy[front], -1);
        		result[1] = indexOf(nums, copy[rear], result[0]);
        		break;
        	}
        	else if (sum>target){
        		rear--;
        	}else{
        		front++;
        	}
        }
        
    	return result;
    }
    
    public int indexOf(int[] array, int target, int excludeIdx){
    	for (int i=0;i<array.length;i++){
    		if (array[i]==target){
    			if (i!=excludeIdx)
    				return i;
    		}
    	}
    	return -1;
    }
	
	public static void main(String[] args) {
		Q001TwoSum q = new Q001TwoSum();
		
		int[] nums = {3,2,4,11,15};
		int target = 19;
		System.out.println(Arrays.toString(q.twoSum(nums, target)));
		
	}

}
