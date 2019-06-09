package round2.Q179LargestNumber;

import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public String largestNumber(int[] nums) {
        if (nums==null)
            return "";

        Integer[] itgs = ints2Integers(nums);
        Arrays.sort(itgs, new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2) {
                String join12 = String.valueOf(i1) + String.valueOf(i2);
                String join21 = String.valueOf(i2) + String.valueOf(i1);

                if (join12.length()!=join21.length()) {
                    return -Integer.compare(join12.length(), join21.length());
                } else {
                    for (int i = 0; i < join12.length(); i++) {
                        if (join12.charAt(i)!=join21.charAt(i))
                            return -Character.compare(join12.charAt(i), join21.charAt(i));
                    }
                    return 0;
                }
            }
        });
        if (!handleLeadingZeros(itgs)) //***bug: didn't handle the case where there are leading zeros
            return "0";
        String ret = itgs2String(itgs);
        return ret;
    }

    private Integer[] ints2Integers(int[] nums) {
        if (nums==null)
            return null;
        Integer[] ret = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++)
            ret[i] = new Integer(nums[i]);
        return ret;
    }

    private String itgs2String(Integer[] itgs) {
        if (itgs==null)
            return null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < itgs.length; i++)
            sb.append(String.valueOf(itgs[i]));
        return new String(sb);
    }

    /**
     * @return : true if there's no leading zero after swapping, else false
     * */
    private boolean handleLeadingZeros(Integer[] nums) {
        if (nums==null)
            return false;

        int firstNotZeroIdx = 0;
        while (firstNotZeroIdx<nums.length && nums[firstNotZeroIdx].equals(0))
            firstNotZeroIdx++;
        if (firstNotZeroIdx==nums.length)
            return false;
        //else: not all zeros, firstNotZeroIdx<nums.len
        //swap
        Integer tmp = nums[0];
        nums[0] = nums[firstNotZeroIdx];
        nums[firstNotZeroIdx] = tmp;
        return true;
    }

}