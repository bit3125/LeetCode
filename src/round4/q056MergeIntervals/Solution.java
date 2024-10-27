package round4.q056MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // sort
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        // merge
        int[] last, cur;
        int lastIdx = 0;
        for (int i = 1; i < intervals.length; i++) {
            last = intervals[lastIdx];
            cur = intervals[i];

            if (cur[0] <= last[1]) { // overlap
                last[1] = Integer.max(last[1], cur[1]); //***BUG: last[1] = cur[1]
            } else {
                lastIdx++;
                intervals[lastIdx] = cur;
            }
        }

        int[][] ret = new int[lastIdx + 1][];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = intervals[i];
        }
        return ret;
    }
}