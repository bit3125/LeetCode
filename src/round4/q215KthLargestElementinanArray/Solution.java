package round4.q215KthLargestElementinanArray;


/**
 * Sn = Ok
 * Tn = nlogk
 */

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k || k <= 0) {
            return 0;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });
        for (int i = 0; i < nums.length; i++) {
            heap.offer(nums[i]);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {2, 1};
        int k = 2;
        Solution sl = new Solution();
        System.out.println(sl.findKthLargest(nums, k));
    }
}