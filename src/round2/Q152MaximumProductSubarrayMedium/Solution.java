package round2.Q152MaximumProductSubarrayMedium;

import java.util.Arrays;

class Solution {
    public int maxProduct(int[] nums) {
        if (nums==null || nums.length==0)
            return 0;

        int dpMaxPrev = nums[0], dpMinPrev = nums[0];
        int maxProduct = nums[0];
        int[] res = new int[3];

        for (int i = 1; i < nums.length; i++) {
            res[0] = nums[i];
            res[1] = dpMaxPrev * nums[i];
            res[2] = dpMinPrev * nums[i];
            // sort
            Arrays.sort(res);
            maxProduct = Integer.max(maxProduct, res[2]);

            // iter
            dpMaxPrev = res[2];
            dpMinPrev = res[0];
        }

        return maxProduct;
    }
}