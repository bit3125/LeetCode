/**算法分析：2d-DP. Tn = O((kn)*n), Sn = O(kn)，其中k为element的最大取值
 *
 * 本质可抽象为：求出是否存在一个组合subset能满足：sum(subset)==sum(nums)/2
 *
 * upBound = ceil(sum(nums)/2)
 * 状态定义：dp[i][j] 表示前i个数（from 0 on, inclusive)的是否存在和为j的子集
 * 转移方程：dp[i][j] = dp[i-1][j] || dp[i-1][k], 0<=k=j-nums[i]<=upBound, 0<=i-1<nums.length
 * 初始条件：1.dp[i][nums[p]]=true, 0<=p<=i
 *          2.others false
 * 在实际实现的时候只要遍历dp[i-1],遇到dp[i-1][x]=true的时候让dp[i][x+nums[i]]=true即可
 * ，之前true的都保留下来(实际只用一个一维dp数组,但是dp方向必须从右至左)
 *
 * 另一算法：Tn = O((kn)^2), Sn = O(kn)
 * 分配一个kn长的boolean数组f，表示某个取值是否能取到
 * 先用elements去初始化对应的boolean为true
 * 然后从头到尾遍历每个取值的所有组合，f[i] = ||(f[p] && f[q]), 0<=p<=i && 0<=q<=i && p+q=i
 * 复杂度比DP高了k倍，deprecate
 *
 *
 * 以后看到两种特点可以考虑使用类骰子DP：
 * 1.求数组中各种取值的组合，复杂度达到O(2^n)的
 * 2.给出数组中每个数的取值上限，甚至给出数组长度上限的，90%是要用这个方法了
 * =>使用dp[i][j]，表示前i个数的某种和取到j值的某种量
 *
 * */

package leetcode.solutions;

import java.util.Arrays;

public class Q416PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        if (nums==null || nums.length==0)
            return false;

        //init
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        if ((sum&1)==1) //odd -> impossible
            return false;
            //else : sum is even
        int upBound = sum/2; // /2+ceil
        boolean[] dp = new boolean[upBound+1]; //***bug:0也占一个取值
        Arrays.fill(dp, false);
        if (nums[0]<=upBound) //***bug:忘了判断越界
            dp[nums[0]] = true;

        //dp
        for (int i = 1; i < nums.length; i++) { //***bug:i from 1 on , not from 0 0n
            for (int k = upBound-nums[i]; k >= 0; k--) { //j<=upBound //还可加设一个curUpBound继续优化
                //***bug:k必须要从后往前迭代！原因明天再写
                int j = k+nums[i];
                if (dp[k] && j<=upBound)  //j依然可能因为nums[i]过大而越界，不可去掉
                    dp[j] = true;
            }
            if (nums[i]<=upBound) //***bug:忘了判断越界
                dp[nums[i]] = true;//必须放在这里不能放在开头，否则代表的是dp[i-1][nums[i]]=true
        }

        return dp[upBound];
    }

    public static void main(String[] args) {
        Q416PartitionEqualSubsetSum q = new Q416PartitionEqualSubsetSum();
        int[] nums = new int[]{2, 2, 3, 5};
        System.out.println(q.canPartition(nums));
    }
}
