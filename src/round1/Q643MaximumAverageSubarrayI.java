package round1;

public class Q643MaximumAverageSubarrayI {

    public double findMaxAverage(int[] nums, int k) {
    	if (nums==null || nums.length<k)
    		return 0;
    	
    	long sum = 0L;
    	for (int i=0;i<k;i++)
    		sum += nums[i];
    	long maxSum = sum;
    	
    	for (int i=k;i<nums.length;i++){
    		if (nums[i]>nums[i-k])
    		sum += nums[i]-nums[i-k];
    		if (sum>maxSum)
    			maxSum = sum;
    	}
    	
    	return maxSum*1.0/k;
    }
	
	public static void main(String[] args) {
		Q643MaximumAverageSubarrayI q = new Q643MaximumAverageSubarrayI();
		int[] nums = {1,12,-5,-6,50,3};
		int k = 4;
		
		System.out.println(q.findMaxAverage(nums, k));
		System.out.println(Double.MAX_VALUE);
	}

}
