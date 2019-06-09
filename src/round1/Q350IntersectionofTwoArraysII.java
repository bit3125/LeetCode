package round1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q350IntersectionofTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1==null || nums2==null)
            return new int[0];

        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++)
            map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);

        for (int i = 0; i < nums2.length; i++) {
            int cnt = map.getOrDefault(nums2[i], 0);
            if (cnt >= 1) {
                list.add(nums2[i]);
                map.put(nums2[i], cnt - 1);
            }
        }

        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }


}
