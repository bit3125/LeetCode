/**算法分析：2d-DP, Tn = O(kn), Sn = Ok, k=[nums.len-1]∑[i=0] (nums[i])
 *
 * 此题可与以下题进行比较：
 * 1.剑指offer掷骰子DP（从前i个色子的取值转移出加入当前色子后的取值）
 * 2.求组合数C，DP（不是求所有组合的可能，求所有组合的可能有两种算法，
 * 第一种跟求组合数是同思想的使用分治法，第二种是boolean数组辅助法）
 *
 * 状态定义：dp[i][j]为前i个数（inclusive）取得j的组合个数
 * 转移方程：dp[i][j] = dp[i-1][src1] + dp[i-1][src2],
 *          其中 -maxValue<=src1=j-nums[i]<=maxValue, -maxValue<=src2=j+nums[i]<=maxValue
 * 初始条件：dp[0][nums[0]] += 1
 *          dp[0][-nums[0]] += 1
 *          这么写是考虑到nums[0]为0的边界情况
 *
 * 思考过程：使用BruteForce的话（穷举所有组合）Tn = O(2^n)，考虑到是否能用DP来做
 * 由于题目中给出了element的具体取值范畴，联想到了使用2d-DP，其中一维可以用element的取值来做
 * 刚开始想到是不是背包问题，后来发现不是，然后就想到了这个状态定义。
 * 进行Tn的对比，在题目背景下，n<=20, maxSum<=1000
 * BruteForce.Tn=2^20 >> DP.Tn=20*1000，故DP是能有效优化Tn的
 *
 * 然后再采取一系列的剪枝、优化Sn操作
 *
 * 顺带一提，组合问题中两种写法：1.分治法；2.boolean辅助数组法
 * 乍一看好像Tn分别为 O(C(m)(n)), O(2^n),
 * 但是实际上第二种方法中我加入了剪枝操作，故实际的复杂度与第一种一样
 * */

package leetcode.solutions;

import java.util.Arrays;

public class Q494TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums==null || nums.length==0)
            return 0;

        int maxValue = 0; // nums[i] in [-maxValue, maxValue], so offset=maxValue. 优化Sn
        for (int i = 0; i < nums.length; i++)
            maxValue += nums[i];
        int rangeLen = maxValue*2+1;
        int[] dpCur = new int[rangeLen], dpPrev = new int[rangeLen], dptmp; //优化Sn
        Arrays.fill(dpCur, 0);
        Arrays.fill(dpPrev, 0);
        dpPrev[nums[0]+maxValue] += 1; //***bug: = 1; Error if nums[0]==0
        dpPrev[-nums[0]+maxValue] += 1;
        int curMaxValue = nums[0]; //剪枝

        int src1, src2;
        for (int i = 1; i < nums.length; i++) {
            curMaxValue += nums[i];
            for (int j = -curMaxValue; j <= curMaxValue; j++) {
                src1 = j+nums[i]+maxValue; //***bug:没有考虑到来源无效
                src2 = j-nums[i]+maxValue;
                dpCur[j+maxValue] = (inRange(src1, rangeLen)?dpPrev[src1]:0)
                        + (inRange(src2, rangeLen)?dpPrev[src2]:0);
            }

            //swap
            dptmp = dpCur;
            dpCur = dpPrev;
            dpPrev = dptmp;
        }

        src1 = S + maxValue;
        return inRange(src1,rangeLen)?dpPrev[src1]:0;
    }

    public boolean inRange(int i, int rangeLen) {
        return 0<=i && i<rangeLen;
    }

    public static void main(String[] args) {
        Q494TargetSum q = new Q494TargetSum();
        int[] nums = new int[]{0,0,0,0,0,0,0,0,1};
        int S = 1;
        q.findTargetSumWays(nums, S);

    }
}
