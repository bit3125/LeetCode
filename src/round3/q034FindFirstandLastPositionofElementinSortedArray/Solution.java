package round3.q034FindFirstandLastPositionofElementinSortedArray;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        int front, rear, mid;

        // find left
        // 让front永远指向 < target的部分
        // 让rear永远指向 >= target的部分
        if (nums[0] == target) {
            //***BUG: 边界判断. 当idx0 == target的时候, front的初始值无法满足定义, 故后面的搜索不会成立
            // 要单拎出来做边界处理.
            result[0] = 0;
        } else {
            front = 0;
            rear = nums.length - 1;
            while (rear - front > 1) {
                mid = (front + rear) / 2;
                if (target <= nums[mid]) {
                    rear = mid;
                } else { // target > nums[mid]
                    front = mid;
                }
            }
            if (nums[rear] != target) {
                return result;
            }
            result[0] = rear;
        }

        // find right
        if (nums[nums.length - 1] == target) {
            //***BUG: 同上
            result[1] = nums.length - 1;
        } else {
            front = 0;
            rear = nums.length - 1;
            while (rear - front > 1) {
                mid = (front + rear) / 2;
                if (target < nums[mid]) {
                    rear = mid;
                } else { // target >= nums[mid]
                    front = mid;
                }
            }
            result[1] = front;
        }

        return result;
    }
}