package round4.q047PermutationsII.solution2;

import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);

        Arrays.sort(nums);
        permuteCore(nums, 0, results, result, visited);
        return results;
    }

    private void permuteCore(int[] nums , int curIdx, List<List<Integer>> results, List<Integer> result, boolean[] visited) {
        if (nums == null) { // illegal
            return;
        }
        if (curIdx >= nums.length) {
            results.add(new ArrayList<>(result));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i-1] && !visited[i-1])) {
                continue;
            }
            visited[i] = true;
            result.add(nums[i]);
            permuteCore(nums, curIdx + 1, results, result, visited);
            result.remove(curIdx);
            visited[i] = false;
        }
    }
}
