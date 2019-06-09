package round1;

/**算法分析：Tn=On, Sn=O1
 * 位运算法
 *
 * */
public class Q268MissingNumber_Solution2 {

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
