/**算法分析：
 * 依然利用的是异或的性质：a^a = 0, 0^b = b
 *
 * */

package round2.Q268MissingNumber.solution2;

class Solution {
    public int missingNumber(int[] nums) {
        if (nums==null || nums.length==0)
            return -1;

        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i]^i;
        }
        xor ^= nums.length;
        return xor;
    }
}