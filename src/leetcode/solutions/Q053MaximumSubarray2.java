/**�㷨����������Ϊ���е�һά��̬�滮����
 * ����f[i]Ϊ���±�i��β���������еĿ�ʼ�±꣬sum[i]Ϊ��i�±��β���������еĺͣ�����
 * ״̬ת�Ʒ��̣�f[i] = 	f[i-1], sum[i]>=0
 * 					i, sum[i]<0
 * 			sum[i] = sum[i-1]+nums[i] ,sum[i]>=0
 * 					 nums[i] ,sum[i]<0
 * ��ʼ������f[0] = 0
 * 		  sum[0] = nusm[0]
 * 
 * �֣�ע�⵽״̬ת��ֻ������ ǰ�� ���ʽ�������������f��sum��Ϊ����prev����������ʹSn��On��ΪO1
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
		// TODO �Զ����ɵķ������

	}

}
