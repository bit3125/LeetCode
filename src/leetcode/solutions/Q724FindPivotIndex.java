package leetcode.solutions;

public class Q724FindPivotIndex {

    public int pivotIndex(int[] nums) {
    	if (nums==null || nums.length==0)
    		return -1;
    	
    	int sum = 0;
    	for (int num : nums)
    		sum += num;
    	
    	int leftSum = 0, rightSum = sum-nums[0];
    	if (leftSum==rightSum)
    		return 0;
    	for (int i=1;i<nums.length;i++){
    		leftSum += nums[i-1];
    		rightSum -= nums[i];
    		if (leftSum==rightSum)
    			return i;
    	}
    	
    	return -1;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
