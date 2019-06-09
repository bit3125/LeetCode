/**算法分析：DP, Tn = On^2
 * f[i] = max{f[j],f[k],....}+1，其中j,k,...<i，nums[j],nums[k]...<nums[i]
 * 
 * */

package round1;

import java.util.Arrays;

public class Q300LongestIncreasingSubsequence_Solution1 {

    public int lengthOfLIS(int[] nums) {
        if (nums==null||nums.length==0)
        	return 0;
        
        int[] f = new int[nums.length];
        Arrays.fill(f, 1);
        for (int i=0;i<f.length;i++){
        	for (int j=i-1;j>=0;j--){
        		if (nums[j]<nums[i] && f[j]+1>f[i]){
        			f[i] = f[j]+1;
        		}
        	}
        }
        
        int maxLen = Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++){
        	if (maxLen<f[i])
        		maxLen = f[i];
        }
        
    	return maxLen;
    }
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
