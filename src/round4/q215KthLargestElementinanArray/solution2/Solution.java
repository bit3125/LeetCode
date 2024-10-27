package round4.q215KthLargestElementinanArray.solution2;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return -1;
        }

        k--;
        // len >= 1
        int start = 0, end = nums.length, pivotIdx = 0;
        while (start < end) {
            pivotIdx = partition(nums, start, end);
            if (pivotIdx < k) {
                start = pivotIdx + 1;
            } else if (pivotIdx > k) {
                end = pivotIdx;
            } else { // ==
                break;
            }
        }

        return nums[pivotIdx];
    }

    private int partition(int[] nums, int start, int end){
        if (nums == null || nums.length == 0 || start < 0 || end > nums.length || end - start <= 1) {
            return start;
        }

        // end - start >= 2
        int pivot;
        int front = start, rear = end - 1;
        pivot = nums[front];
        while (front < rear) {
            while (front < rear && nums[rear] <= pivot) {
                rear--;
            }
            if (front < rear) {
                nums[front] = nums[rear];
            }
            while (front < rear && nums[front] > pivot) {
                front++;
            }
            if (front < rear) {
                nums[rear] = nums[front];
            }
        }
        nums[front] = pivot;

        return front;
    }
}