package leetcode.solutions;
import java.util.Arrays;

public class Q189RotateArray {

	/*
	 * 驱逐式的交换法：产生死链，不可取
	 * */
//    public void rotate(int[] nums, int k) {
//    	if (nums==null || nums.length==0 || k<=0)
//    		return;
//    	
//    	int idx, cnt;
//    	int storage, tmp; //暂存， 交换缓存
//    	
//    	idx = 0;
//    	cnt = 0;
//    	storage = nums[idx];
//    	while(cnt<nums.length){
//    		System.out.println(Arrays.toString(nums));
//    		idx = (idx+k)%nums.length;
//    		
//    		//swap
//    		tmp = nums[idx];
//    		nums[idx] = storage;
//    		storage = tmp;
//    		
//    		cnt++;
//    	}
//    }
	
	public void rotate(int[] nums, int k){
		if (nums==null || nums.length==0 || k<=0)
			return;
		
		k%=nums.length;
		
		reverse(nums, 0, nums.length-1);
		reverse(nums, 0, k-1);
		reverse(nums, k, nums.length-1);
	}
	
	public void reverse(int[] nums, int front, int rear){
		while(front<rear){
			//swap
			int tmp = nums[front];
			nums[front] = nums[rear];
			nums[rear] = tmp;
			
			front++;
			rear--;
		}
	}
    
	public static void main(String[] args) {
		Q189RotateArray q = new Q189RotateArray();
		int[] nums = {1,2,3,4,5,6,7};
		int k = 3;
//		int[] nums = {1,2,3,4,5,6};
//		int k = 2;
		
		q.rotate(nums, k);
		
		System.out.println(Arrays.toString(nums));
	}

}
