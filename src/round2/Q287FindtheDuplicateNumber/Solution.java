package round2.Q287FindtheDuplicateNumber;

class Solution {
    public int findDuplicate(int[] nums) {
        if (nums==null || nums.length==0)
            return -1;

        int idx = 0, corIdx, curNum;
        while (true) {
            curNum = nums[idx];
            corIdx = curNum - 1;
            if (corIdx == idx) {
                idx ++;
                continue;
            } else if (nums[corIdx] != curNum) {
                swap(nums, idx, corIdx);
            } else {
                return curNum;
            }
        }

    }

    private void swap(int[] nums, int i, int j) {
        if (nums==null || nums.length==0)
            return;

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}