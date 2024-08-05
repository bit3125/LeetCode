package round4.q088MergeSortedArray;

import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null || m > nums1.length || n > nums2.length) {
            return;
        }

        int[] nums3 = Arrays.copyOf(nums1, m);
        int idx1 = 0, idx3 = 0, idx2 = 0;
        while (idx3 < m && idx2 < n) {
            if (nums3[idx3] < nums2[idx2]) {
                nums1[idx1] = nums3[idx3];
                idx1++;
                idx3++;
            } else {
                nums1[idx1] = nums2[idx2];
                idx1++;
                idx2++;
            }
        }
        while (idx3 < m) {
            nums1[idx1] = nums3[idx3];
            idx1++;
            idx3++;
        }
        while (idx2 < n) {
            nums1[idx1] = nums2[idx2];
            idx1++;
            idx2++;
        }
    }
}