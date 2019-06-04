package leetcode.solutions;

import java.util.PriorityQueue;

public class Q215KthLargestElementinanArray {

	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		int idx = 0;
		while (idx < k) {
			minHeap.add(nums[idx++]);
		}
		while (idx < nums.length) {
			if (minHeap.peek() < nums[idx]) {
				minHeap.poll();
				minHeap.add(nums[idx]);
			}
			idx++;
		}

		return minHeap.peek();
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
