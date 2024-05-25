package round3.q215KthLargestElementinanArray;

import java.util.Arrays;

public class Solution {
    // quick select
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || k > nums.length) {
            return -1;
        }

        return quickSelect(nums, 0, nums.length, k - 1);
    }

    public int quickSelect(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return -1;
        }

        int pivotIdx = partition(nums, start, end, k);
        if (pivotIdx > k) {
            return quickSelect(nums, start, pivotIdx, k);
        } else if (pivotIdx < k) {
            return quickSelect(nums, pivotIdx + 1, end, k);
        } else { // ==
            return nums[pivotIdx];
        }
    }

    public int partition(int[] nums, int start, int end, int k) {
        if (start >= end) { // robust
            return -1;
        }

        int front = start, rear = end - 1;
        int pivot = nums[front];
        while (front < rear) {
            while (front < rear && nums[rear] < pivot) {
                rear--;
            }
            if (front < rear) {
                nums[front] = nums[rear];
            }

            while (front < rear && nums[front] >= pivot) {
                front++;
            }
            if (front < rear) {
                nums[rear] = nums[front];
            }
        }

        // front must be equals rear
        nums[front] = pivot;
        return front;
    }

    // just for practice writing quickSort
    public void quickSort(int[] nums) {
        if (nums == null) {
            return;
        }

        partition(nums, 0, nums.length);

    }

    public void quickSortCore(int[] nums, int start, int end) {
        if (end - start <= 1) {
            return;
        }

        int pivotIdx = partition(nums, start, end);
        quickSortCore(nums, start, pivotIdx);
        quickSortCore(nums, pivotIdx + 1, end);
    }

    public int partition(int[] nums, int start, int end) {
        if (end - start <= 1) { // robust
            return start;
        }

        int front = start, rear = end - 1;
        int pivot = nums[front];
        while (front < rear) {
            while (front < rear && nums[rear] < pivot) {
                rear--;
            }
            if (front < rear) {
                nums[front] = nums[rear];
            }

            while (front < rear && nums[front] >= pivot) {
                front++;
            }
            if (front < rear) {
                nums[rear] = nums[front];
            }
        }

        // front must be equals rear
        nums[front] = pivot;
        return front;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] nums = new int[]{5, 3, 8, 5, 3, 2, 1, 9};
        sl.quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}