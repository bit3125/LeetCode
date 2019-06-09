package round1;

public class Q136SingleNumber {

    public int singleNumber(int[] nums) {
        if (nums==null || nums.length==0)
        	return Integer.MAX_VALUE;
    	int res = 0;
        
        
        for (int i=0;i<nums.length;i++)
        	res ^= nums[i];
        
        return res;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
	}

}
