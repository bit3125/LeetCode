package round2.Q056MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals==null || intervals.length==0)
            return new int[0][];

        List<int[]> results = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int[] prevInterv = intervals[0], curInterv;
        int idx = 1;
        while (idx < intervals.length) {
            curInterv = intervals[idx];
            if (prevInterv[1] >= curInterv[0]) {
                prevInterv = mergeInterv(prevInterv, curInterv);
            } else {
                results.add(prevInterv);
                prevInterv = curInterv;
            }
            idx++;
        }
        results.add(prevInterv);

        return list2Array(results);
    }

    /**
     * a & b must be legal
     * */
    private int[] mergeInterv(int[] a, int[] b) {
        return new int[]{a[0], Integer.max(a[1], b[1])};
    }

    private int[][] list2Array(List<int[]> list) {
        int[][] ret = new int[list.size()][];
        for (int i = 0; i < list.size(); i++)
            ret[i] = list.get(i);
        return ret;
    }
}