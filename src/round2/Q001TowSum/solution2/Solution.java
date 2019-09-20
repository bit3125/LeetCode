package round2.Q001TowSum.solution2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums==null || nums.length==0)
            return null;

        int[] result = new int[2];
        Map<Integer, List<Integer>> map = new HashMap<>(); // value:(list of idxs)
        for (int i = 0; i < nums.length; i++) {
            List<Integer> curList = map.getOrDefault(nums[i], new ArrayList<>());
            curList.add(i);
            map.put(nums[i], curList);
        }

        int aValue, bValue;
        List<Integer> aIdxs, bIdxs;
        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            aValue = e.getKey();
            bValue = target - aValue;
            if (map.containsKey(bValue)) {
                aIdxs = map.get(aValue);
                result[0] = aIdxs.get(0);
                if (bValue == aValue) {
                    if (aIdxs.size() >= 2) {
                        result[1] = aIdxs.get(1);
                        return result;
                    }
                } else {
                    bIdxs = map.get(bValue);
                    result[1] = bIdxs.get(0);
                    return result;
                }
            }
        }

        return null;
    }
}
