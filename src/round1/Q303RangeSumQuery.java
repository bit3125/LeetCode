package round1;
import java.util.Arrays;

public class Q303RangeSumQuery {

	private int[] nums;
	private int[] sums;
	
    public Q303RangeSumQuery(int[] nums) {
        this.nums = nums;
        this.sums = new int[nums.length];
        
        int sum = 0;
        for (int i=0;i<nums.length;i++){
        	sum += nums[i];
        	sums[i] = sum; 
        }
        
    }
    
    public int sumRange(int i, int j) {
    	if (i<0 || j>=nums.length || i>j )
    		return -1;
    	
    	if (i==0)
    		return sums[j];
    	else
    		return sums[j]-sums[i-1];
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
