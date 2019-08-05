package round2.Q033SearchinRotatedSortedArray;

// TODO
class Solution {
    public int search(int[] nums, int target) {
        if (nums==null || nums.length==0)
            return -1;

        int front = 0, rear = nums.length-1, mid;
        while (front < rear) {
            mid = (front + rear) / 2;
            if (nums[mid] == 1) {

            } else if (nums[mid] == 2) {

            } else { // ==

            }
        }

        return -1;
    }
}