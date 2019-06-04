/**算法分析：类归并排序，Tn=On, Sn=O1
 * 使用类归并排序的算法，再对总数为奇偶的情况做下分别处理
 *
 * */

package leetcode.solutions;

public class Q004MedianofTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ( nums1==null&&nums2==null )
            return 0;

        int totalSize = nums1.length + nums2.length;
        int totalIdx = 0;
        int midIdx = totalSize/2+1;
        int idx1 = 0, idx2 = 0;
        int prevNum = Integer.MIN_VALUE, curNum = Integer.MIN_VALUE;

        while (idx1 < nums1.length && idx2 < nums2.length && totalIdx<midIdx ) {
            prevNum = curNum;
            if (nums1[idx1]<nums2[idx2]){
                curNum = nums1[idx1];
                idx1++;
            }else{
                curNum = nums2[idx2];
                idx2++;
            }
            totalIdx++;
        }
        while (idx1<nums1.length && totalIdx<midIdx ){
            prevNum = curNum;
            curNum = nums1[idx1];
            idx1++;
            totalIdx++;
        }
        while(idx2<nums2.length && totalIdx<midIdx){
            prevNum = curNum;
            curNum = nums2[idx2];
            idx2++;
            totalIdx++;
        }

        return (totalSize&1)==1?curNum:(curNum+prevNum)*1.0/2;
    }

}
