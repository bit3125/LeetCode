package round2.Q268MissingNumber.solution1;

class Solution {
    public int missingNumber(int[] nums) {
        if (nums==null || nums.length==0)
            return -1;
        int realSum = 0, targetSum = (1+nums.length)*nums.length/2;
        for (int i = 0; i < nums.length; i++)
            realSum += nums[i];
        return targetSum - realSum;
    }
}