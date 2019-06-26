package round2.Q046Permutations;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            results.add(new ArrayList<>());
            return results;
        }

        permuteCore(nums, results, 0);
        return results;
    }

    private void permuteCore(int[] nums, List<List<Integer>> results, int curIdx) {
        if (curIdx == nums.length) {
            List<Integer> result = new ArrayList<Integer>();
            for (int i = 0; i < nums.length; i++)
                result.add(nums[i]);
            results.add(result);
        }

        for (int i = curIdx; i < nums.length; i++) {
            swap(nums, curIdx, i);
            permuteCore(nums, results, curIdx+1);
            swap(nums, curIdx, i); // backtracking
        }

    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}