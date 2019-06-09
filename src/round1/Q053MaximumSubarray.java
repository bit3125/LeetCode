package round1;

public class Q053MaximumSubarray {

    public int maxSubArray(int[] nums) {
        if (nums==null||nums.length==0)
        	return 0;
        
        int[] f = new int[nums.length]; 
        int[] sums = new int[nums.length];
        
        f[0] = 0;
        sums[0] = nums[0];
        for (int i=1;i<nums.length;i++){
        	if (sums[i-1]>=0){
        		f[i] = f[i-1];
        		sums[i] = sums[i-1];
        	}else{
        		f[i] = i;
        		sums[i] = nums[i];
        	}
        }
        
        int maxSum = sums[0];
        for (int i=0;i<nums.length;i++){
        	if (sums[i]>maxSum){
        		maxSum = sums[i];
        	}
        }
        
        return maxSum;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
