package leetcode.solutions;

import java.util.Arrays;
import java.util.Comparator;

public class Q179LargestNumber {

    public String largestNumber(int[] nums) {
        if (nums==null || nums.length==0)
            return "";

        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);

        //sort
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a = o1 + o2, b = o2 + o1;
                return -a.compareTo(b);
            }
        });

        //***bug: process 0 at head
        if (Integer.valueOf(strs[0]) == 0) {
            int idx = 0;
            while (idx<strs.length && Integer.valueOf(strs[idx]) == 0)
                idx++;
            if (idx < strs.length) {
                String tmp = strs[idx];
                strs[idx] = strs[0];
                strs[0] = tmp;
            } else {
                return "0";
            }
        }

        String ret="";
        for (int i = 0; i < strs.length; i++)
            ret += strs[i];
        return ret;
    }

}
