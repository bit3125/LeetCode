package round4.q046Permutations;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }

        core(nums, 0, results);
        return results;
    }

    private void core(int[] nums, int curPosition, List<List<Integer>> results) {
        if (curPosition >= nums.length) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                result.add(nums[i]);
            }
            results.add(result);
            return;
        }

        for (int i = curPosition; i < nums.length; i++) {
            swap(nums, curPosition, i);
            core(nums, curPosition + 1, results);
            swap(nums, curPosition, i);
        }
    }

    private void swap(int[] nums, int i, int j){
        if (nums == null || i >= nums.length || j >= nums.length) {
            return;
        }

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}