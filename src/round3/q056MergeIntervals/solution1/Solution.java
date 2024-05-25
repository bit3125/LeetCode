package round3.q056MergeIntervals.solution1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;


/**
 * 思路正确, 不够简洁
 * 看solution2
 * */

public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return null;
        }

        List<int[]> result = new ArrayList<>();

        // sort
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        // merge
        int[] merged;
        int i = 0, j;
        while (i < intervals.length) {
            j = i + 1;
            while (j < intervals.length) {
                merged = tryMerge(intervals[i], intervals[j]);
                if (merged == null) {
                    break;
                }

                intervals[i] = merged;
                j++;
            }

            result.add(intervals[i]);
            i = j;
        }

        // construct ret
        int[][] ret = new int[result.size()][];
        for (int k = 0; k < result.size(); k++) {
            ret[k] = result.get(k);
        }
        return ret;
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
