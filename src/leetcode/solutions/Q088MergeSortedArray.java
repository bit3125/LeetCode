package leetcode.solutions;

public class Q088MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1==null || nums2==null)
            return ;

        int idx1 = m-1, idx2 = n-1;
        int idxTail = nums1.length - 1;
        while (idx1 >= 0 && idx2 >= 0)
            nums1[idxTail--] = nums1[idx1] > nums2[idx2] ? nums1[idx1--] : nums2[idx2--];
        while (idx1 >= 0)
            nums1[idxTail--] = nums1[idx1--];
        while (idx2 >= 0)
            nums1[idxTail--] = nums2[idx2--];
    }

}
