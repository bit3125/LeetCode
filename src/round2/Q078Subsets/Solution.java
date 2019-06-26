package round2.Q078Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums==null || nums.length==0){
            results.add(new ArrayList<>());
            return results;
        }

        boolean[] selected = new boolean[nums.length];
        Arrays.fill(selected, false);
        helper(nums, selected, 0, results);

        return results;
    }

    public void helper(int[] nums, boolean[] selected, int curIdx, List<List<Integer>> results) {
        if (curIdx == nums.length) {
            results.add(getResult(nums, selected));
            return ;
        }

        selected[curIdx] = true;
        helper(nums, selected, curIdx + 1, results);
        selected[curIdx] = false;
        helper(nums, selected, curIdx + 1, results);
        // 无需回溯，每次递归调用之前会先对selected状态数组重新赋值
    }

    private List<Integer> getResult(int[] nums, boolean[] selected) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (selected[i]) {
                result.add(nums[i]);
            }
        }
        return result;
    }

}