package round2.Q239SlidingWindowMaximum;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums==null || nums.length==0)
            return new int[0];

        int[] results = new int[nums.length-k+1];
        Deque<int[]> win = new LinkedList<>();

        // step on
        int[] curPair;
        for (int i = 0; i < nums.length; i++) {
            // push
            curPair = new int[]{i, nums[i]};
            while ( (!win.isEmpty()) && win.getLast()[1] < curPair[1])
                win.removeLast();
            win.addLast(curPair);
            // remove those out of range
            while (win.getFirst()[0] <= i - k) // will be only excuted once
                win.removeFirst();

            // add max
            if (i - k + 1 >= 0) //***bug:forget
                results[i-k+1] = win.getFirst()[1]; //***bug: results[i]
        }

        return results;
    }
}