package round3.q0153Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return results;
        }

        Arrays.sort(nums);

        List<Integer> result;
        int front, rear, sumIdx = 0;
        int twoSum;
        while (sumIdx < nums.length - 2) {
            if (sumIdx > 0 && nums[sumIdx] == nums[sumIdx - 1]) {
                sumIdx++;
                continue;
            }

            front = sumIdx + 1;
            rear = nums.length - 1;
            while (front < rear) {
                if (front > sumIdx + 1 && nums[front] == nums[front - 1]) { //***BUG: 没做同值skip
                    front++;
                    continue;
                }
                if (rear < nums.length - 1 && nums[rear] == nums[rear + 1]) {
                    rear--;
                    continue;
                }

                twoSum = nums[front] + nums[rear];
                if (twoSum + nums[sumIdx] < 0) {
                    front++;
                } else if (twoSum + nums[sumIdx] > 0) {
                    rear--;
                } else {
                    result = new ArrayList<>(3);
                    result.add(nums[sumIdx]);
                    result.add(nums[front]);
                    result.add(nums[rear]);
                    results.add(result);
                    front++;
                }
            }

            sumIdx++;
        }

        return results;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(sl.threeSum(nums));
    }
}