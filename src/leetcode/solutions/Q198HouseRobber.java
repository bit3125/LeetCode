/**算法分析：1d DP , 
 * 状态定义：f[i] 为 0~i间房子能得到的最高价值
 * 状态转移方程：f[i] = max{f[i-1], f[i-2]+nums[i]}
 * 初始条件：f[0] = nums[0] , f[1] = max{nums[0], nums[1]}
 * 
 * f[i] 有两个转移来源：1.偷house[i]时， 不能偷house[i-1]，则 来源于f[i-2](前面的房子偷不偷无所谓，只要house[i-1]不偷就好)；
 * 					2.不偷house[i]时，则来源于f[i-1](反正不偷house[i]，无所谓偷不偷house[i-1])
 * 
 * */


package leetcode.solutions;

public class Q198HouseRobber {

	public int rob(int[] nums) {
		if (nums==null || nums.length==0)
			return 0;
		if (nums.length==1)
			return nums[0];
		
		//else: nums.length>=2
		//init
		int[] f = new int[nums.length];
		f[0] = nums[0];
		f[1] = Integer.max(nums[1], nums[0]);
		
		for (int i=2;i<nums.length;i++){
			f[i] = Integer.max(f[i-1], f[i-2]+nums[i]);
		}
		
		return f[f.length-1];
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
