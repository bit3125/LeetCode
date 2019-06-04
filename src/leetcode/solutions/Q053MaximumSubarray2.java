/**算法分析：本质为数列的一维动态规划问题
 * 定义f[i]为以下标i结尾的最大和子列的开始下标，sum[i]为以i下标结尾的最大和子列的和，则有
 * 状态转移方程：f[i] = 	f[i-1], sum[i]>=0
 * 					i, sum[i]<0
 * 			sum[i] = sum[i-1]+nums[i] ,sum[i]>=0
 * 					 nums[i] ,sum[i]<0
 * 初始条件：f[0] = 0
 * 		  sum[0] = nusm[0]
 * 
 * 又，注意到状态转移只依赖于 前项 ，故将两个辅助数组f与sum简化为两个prev辅助变量，使Sn从On降为O1
 * 
 * */

package leetcode.solutions;

public class Q053MaximumSubarray2 {

	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int startIdxPrev, sum, sumPrev;
		startIdxPrev = 0;
		sumPrev = nums[0];
		int maxSum = sumPrev;
		for (int i = 1; i < nums.length; i++) {
			if (sumPrev >= 0) {
				sum = sumPrev + nums[i];
			} else {
				startIdxPrev = i;
				sum = nums[i];
			}
			sumPrev = sum;

			if (sum > maxSum)
				maxSum = sum;
		}
		return maxSum;
	}

//	public int maxSubArray(int[] nums) {
//		if (nums == null || nums.length == 0)
//			return 0;
//
//		int[] f = new int[nums.length];
//		int[] sums = new int[nums.length];
//
//		f[0] = 0;
//		sums[0] = nums[0];
//		for (int i = 1; i < nums.length; i++) {
//			if (sums[i - 1] >= 0) {
//				f[i] = f[i - 1];
//				sums[i] = sums[i - 1];
//			} else {
//				f[i] = i;
//				sums[i] = nums[i];
//			}
//		}
//
//		int maxSum = sums[0];
//		for (int i = 0; i < nums.length; i++) {
//			if (sums[i] > maxSum) {
//				maxSum = sums[i];
//			}
//		}
//
//		return maxSum;
//	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
