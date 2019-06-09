package round1;
import java.util.Arrays;

public class Q026RemoveDuplicatesfromSortedArray_Solution1 {

    public int removeDuplicates(int[] nums) {
    	if (nums==null || nums.length==0)
    		return 0;
    	
    	int front = 0;
    	int rear = 0;
    	while(rear<nums.length){
    		while(rear+1<nums.length && nums[rear]==nums[rear+1]){
    			rear++;
    		}//遍历完相同段，idx指向该段最后一个数字
    		nums[front] = nums[rear];
    		front++;
    		rear++;
    	}
    	
    	return front;
    }
	
	public static void main(String[] args) {
		Q026RemoveDuplicatesfromSortedArray_Solution1 q = new Q026RemoveDuplicatesfromSortedArray_Solution1();
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		
		System.out.println(q.removeDuplicates(nums));
		System.out.println(Arrays.toString(nums));
	}

}
