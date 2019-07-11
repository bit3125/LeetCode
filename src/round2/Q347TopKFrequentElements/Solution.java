package round2.Q347TopKFrequentElements;

import java.util.*;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> results = new ArrayList<>();
        if (nums==null || nums.length==0)
            return results;

        Map<Integer, Integer> cnts = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return -o1.getValue().compareTo(o2.getValue());
            }
        });

        // cnt
        for (int i = 0; i < nums.length; i++)  //On
            cnts.put(nums[i], cnts.getOrDefault(nums[i], 0)+1);
        // sort
        for (Map.Entry<Integer, Integer> entry : cnts.entrySet()) //O n*logn
            maxHeap.offer(entry);
        // add
        for (int i = 0; i < k; i++)
            results.add(maxHeap.poll().getKey());

        return results;
    }
}