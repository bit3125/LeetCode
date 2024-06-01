package round3.q078Subsets;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }

        subsetsCore(nums, nums.length, results);
        return results;
    }

    public void subsetsCore(int[] nums, int end, List<List<Integer>> results) {
        if (end == 0) {
            results.add(new ArrayList<>());
            return;
        }

        subsetsCore(nums, end - 1, results);

        int curNum = nums[end - 1];
        List<Integer> newResult;
        List<List<Integer>> newResults = new ArrayList<>();
        for (List<Integer> result : results) {
            newResult = new ArrayList<>(result);
            newResult.add(curNum/** cur Num*/);
            newResults.add(newResult);
        }

        results.addAll(newResults);
    }
}