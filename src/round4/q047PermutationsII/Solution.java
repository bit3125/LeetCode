package round4.q047PermutationsII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }

        permuteCore(nums, results, 0);
        return results;
    }

    private void permuteCore(int[] nums, List<List<Integer>> results, int curIdx) {
        if (nums == null) { // illegal
            return;
        }
        if (curIdx >= nums.length) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                result.add(nums[i]);
            }
            results.add(result);
            return;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = curIdx; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            swap(nums, curIdx, i);
            permuteCore(nums, results, curIdx + 1);
            swap(nums, curIdx, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (nums == null || i >= nums.length || j >= nums.length) {
            return;
        }

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}