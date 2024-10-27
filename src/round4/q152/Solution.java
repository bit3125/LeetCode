package round4.q152;

import java.util.Arrays;

/**
 * 本质上是动态规划
 * 状态定义：
 * dp_prev_max[i]为以 nums[i]结尾的连续子数组里乘积最大的
 * dp_prev_min[i]为以 nums[i]结尾的连续子数组里乘积最大的
 * dp_prev_max[i]只可能能从三个候选数中取得：dp_prev_max[i-i] * nums[i], dp_prev_min[i-1] * nums[i], nums[i]
 *
 * 状态转移方程伪代码：
 * for i
 *  a = dp_prev_max[i-i] * nums[i]
 *  b = dp_prev_min[i-1] * nums[i]
 *  c = nums[i]
 *  dp_prev_max[i] = max(a, b, c)
 *  dp_prev_min[i] = min(a, b, c)
 *
 * result = max(dp_prev_max)
 *
 * 由于状态转移只与前者有关， dp数组可被优化为单变量
 * */

class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int maxPrevProd = nums[0] /*dp1*/, minPrevProd = nums[0] /*dp2*/, maxProd = nums[0];
        int[] candidates = new int[3];
        for (int i = 1; i < nums.length; i++) {
            candidates[0] = maxPrevProd * nums[i];
            candidates[1] = minPrevProd * nums[i];
            candidates[2] = nums[i];

            Arrays.sort(candidates);
            maxPrevProd = candidates[2];
            minPrevProd = candidates[0];
            maxProd = Integer.max(maxProd, maxPrevProd);
        }

        return maxProd;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, -2, 4};
        Solution sl = new Solution();
        System.out.println(sl.maxProduct(nums));
    }
}