package round1;

import java.util.Arrays;

public class Q324WiggleSortII_deprecated {

    public void wiggleSort(int[] nums) {
        if (nums==null || nums.length==0)
            return ;

        Arrays.sort(nums);
        int[] copy = Arrays.copyOf(nums, nums.length);
        for (int i = 0, j = (copy.length+1)/2, idx = 0; j<copy.length ;i++, j++, idx+=2) {
            nums[idx] = copy[i];
            nums[idx+1] = copy[j];
        }
        if ( (copy.length & 1) == 1 ) {
            nums[nums.length-1] = copy[(copy.length+1)/2-1];
        }
    }

}
