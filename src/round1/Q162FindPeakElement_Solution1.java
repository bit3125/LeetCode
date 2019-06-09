/**Ëã·¨·ÖÎö£ºBruteForce Tn = On
 * */

package round1;

public class Q162FindPeakElement_Solution1 {
    public int findPeakElement(int[] nums) {
        if (nums==null||nums.length==0)
            return -1;

        for (int i = 0; i < nums.length; i++)
            if ( (i==0 || nums[i-1]<nums[i]) && (i==nums.length-1 || nums[i]>nums[i+1]) )
                return i;
        return -1;
    }

}
