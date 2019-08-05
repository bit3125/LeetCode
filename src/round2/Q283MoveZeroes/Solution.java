package round2.Q283MoveZeroes;

class Solution {
    public void moveZeroes(int[] nums) {
        if (nums==null || nums.length==0)
            return ;

        int front = 0, rear = 0;
        while (rear < nums.length) {
            if (nums[rear] != 0)
                nums[front++] = nums[rear];
            rear++;
        }

        while (front < nums.length)
            nums[front++] = 0;
    }
}