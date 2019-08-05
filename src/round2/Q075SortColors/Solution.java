package round2.Q075SortColors;

class Solution {
    public void sortColors(int[] nums) {
        if (nums==null || nums.length==0)
            return ;

        // 分别指向三者的边界(exclusive)
        int front = 0, mid = 0, rear = nums.length-1;
        while (mid <= rear) {
            if (nums[mid] == 0) {
                swap(nums, front, mid);
                front++;
                mid++;
            } else if (nums[mid] == 2) {
                swap(nums, rear, mid);
                rear--;
            } else // == 1
                mid++;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}