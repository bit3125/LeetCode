package round1;
/**另类的思路：
 * 使用 新数组的末尾数来做标兵，来判断是否写入的标准，这样就可以对每一位都适用，不需要内嵌循环
 * Q080同理，也可以这么写。
 * 
 * */

import java.util.Arrays;

public class Q026RemoveDuplicatesfromSortedArray_Solution2 {

    public int removeDuplicates(int[] nums) {
    	if (nums==null || nums.length==0)
    		return 0;
    	
    	int front = 1;
    	int rear = 1;
    	while(rear<nums.length){
    		//把每个相同段的第一个数字写入
    		if (nums[rear]!=nums[front-1]){
    			nums[front] = nums[rear];
    			front++;
    		}
			rear++;
    	}
    	
    	return front;
    }
	
	public static void main(String[] args) {
		Q026RemoveDuplicatesfromSortedArray_Solution2 q = new Q026RemoveDuplicatesfromSortedArray_Solution2();
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		
		System.out.println(q.removeDuplicates(nums));
		System.out.println(Arrays.toString(nums));
	}

}
