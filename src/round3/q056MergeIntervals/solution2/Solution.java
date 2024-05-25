package round3.q056MergeIntervals.solution2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 1) {
            return intervals;
        }

        // sort
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        // merge
        int[] merged;
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; ++i) {
            merged = tryMerge(result.get(result.size() - 1), intervals[i]);
            if (merged == null) {
                result.add(intervals[i]);
            } else {
                result.set(result.size() - 1, merged);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public int[] tryMerge(int[] interval1, int[] interval2) {
        if (interval1 == null || interval2 == null || interval1.length != 2 || interval2.length != 2) {
            return null;
        }

        if (interval1[1] < interval2[0]) {
            return null;
        }

        return new int[]{interval1[0], Integer.max(interval1[1], interval2[1])};
    }
}