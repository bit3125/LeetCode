package leetcode.solutions;

/**算法分析： Tn = On, Sn = O1
 * 本算法的思想实在是不太好理解，可按照如下解释：
 * 维护两个bound变量， 对nums进行遍历，遍历的过程中不断更新两个bound
 * 可以理解为，当遍历到i的时候，[0, i-1]之间的子数组中，存在若干长度为1的递增子序列与若干长度为2的递增子序列
 * 我们使用len1Bound来保存前者中的rightBound最小者，使用len2Bound来保存后者中的rightBound最小者
 * 为何只保存rightBound最小的那个子序列呢？是因为后面遍历到的元素中，如果能满足rightBound最小的那个子序列，那么一定也能满足其他的子序列。
 *
 * 对nums进行遍历，
 * 当 nums[i] <= len1Bound的时候，那么长度为1递增子序列的rightBound就可以更新
 * 当 len1Bound < nums[i] <= len2Bound 的时候，那么长度为2递增子序列的rightBound就可以更新(<保证了i前面有长度为1的递增子序列
 * 能与其拼接，变成长度为2的递增子序列)
 * 当 nums[i]> len2Bound 的时候，说明nums[i]前面存在长度为2的递增子序列，能与其拼接，return true
 *
 * 本算法亦可推广到 targetLen=k 的情况。
 * */
public class Q334IncreasingTripletSubsequence_Solution2 {

    public boolean increasingTriplet(int[] nums) {
        if (nums==null || nums.length<3)
            return false;

        int len1Bound = Integer.MAX_VALUE, len2Bound = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= len1Bound) { // nums[i] <= len1Bound
                len1Bound = nums[i];
            } else if (nums[i] <= len2Bound) { // len1Bound< nums[i] <=len2Bound
                len2Bound = nums[i];
            } else { //nums[i]> len2Bound
                return true;
            }
        }

        return false;
    }

}
