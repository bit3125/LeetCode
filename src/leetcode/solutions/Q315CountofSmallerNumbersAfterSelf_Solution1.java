package leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q315CountofSmallerNumbersAfterSelf_Solution1 {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ret = new ArrayList<>(nums.length);
        if (nums==null || nums.length==0)
            return ret;

        //construct data[][]
        int[][] data = new int[nums.length][];
        for (int i = 0; i < data.length; i++)  //oldIdx, data, cnt
            data[i] = new int[]{i, nums[i], 0};
        int[][] copy = new int[nums.length][];

        mergeSort(data, copy, 0, nums.length);
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        for (int i = 0; i < data.length; i++)
            ret.add(data[i][2]);
        return ret;
    }

    public void mergeSort(int[][] data, int[][] copy, int start, int end) {
        if (end-start<=1)
            return;

        //end-start>=2
        int mid = (start + end) / 2;
        mergeSort(data, copy, start, mid);
        mergeSort(data, copy, mid, end);
        merge(data, copy, start, mid, mid, end);

    }

    public void merge(int[][] data, int[][] copy, int s1, int e1, int s2, int e2) {
        if (s1>=e1 || s2>=e2) //useless
            return ;

        System.arraycopy(data, s1, copy, s1, e2-s1);
        int idx = s1;
        while (s1 < e1 && s2 < e2) {
            if (copy[s1][1] > copy[s2][1]) {
                copy[s1][2] += e2 - s2;
                data[idx++] = copy[s1++];
            } else {//<=
                data[idx++] = copy[s2++];
            }
        }
        while (s1 < e1)
            data[idx++] = copy[s1++];
        while (s2 < e2)
            data[idx++] = copy[s2++];

    }

}
