package round1;

/**算法分析：Tn=On, Sn=O1
 * 求和法
 * */
public class Q268MissingNumber_Solution1 {

    public int missingNumber(int[] nums) {
        if (nums==null || nums.length==0)
            return -1;

        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        return nums.length*(nums.length+1)/2-sum;
    }

}
