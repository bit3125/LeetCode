/**�㷨������2d-DP, Tn = O(kn), Sn = Ok, k=[nums.len-1]��[i=0] (nums[i])
 *
 * ���������������бȽϣ�
 * 1.��ָoffer������DP����ǰi��ɫ�ӵ�ȡֵת�Ƴ����뵱ǰɫ�Ӻ��ȡֵ��
 * 2.�������C��DP��������������ϵĿ��ܣ���������ϵĿ����������㷨��
 * ��һ�ָ����������ͬ˼���ʹ�÷��η����ڶ�����boolean���鸨������
 *
 * ״̬���壺dp[i][j]Ϊǰi������inclusive��ȡ��j����ϸ���
 * ת�Ʒ��̣�dp[i][j] = dp[i-1][src1] + dp[i-1][src2],
 *          ���� -maxValue<=src1=j-nums[i]<=maxValue, -maxValue<=src2=j+nums[i]<=maxValue
 * ��ʼ������dp[0][nums[0]] += 1
 *          dp[0][-nums[0]] += 1
 *          ��ôд�ǿ��ǵ�nums[0]Ϊ0�ı߽����
 *
 * ˼�����̣�ʹ��BruteForce�Ļ������������ϣ�Tn = O(2^n)�����ǵ��Ƿ�����DP����
 * ������Ŀ�и�����element�ľ���ȡֵ���룬���뵽��ʹ��2d-DP������һά������element��ȡֵ����
 * �տ�ʼ�뵽�ǲ��Ǳ������⣬�������ֲ��ǣ�Ȼ����뵽�����״̬���塣
 * ����Tn�ĶԱȣ�����Ŀ�����£�n<=20, maxSum<=1000
 * BruteForce.Tn=2^20 >> DP.Tn=20*1000����DP������Ч�Ż�Tn��
 *
 * Ȼ���ٲ�ȡһϵ�еļ�֦���Ż�Sn����
 *
 * ˳��һ�ᣬ�������������д����1.���η���2.boolean�������鷨
 * էһ������Tn�ֱ�Ϊ O(C(m)(n)), O(2^n),
 * ����ʵ���ϵڶ��ַ������Ҽ����˼�֦��������ʵ�ʵĸ��Ӷ����һ��һ��
 * */

package leetcode.solutions;

import java.util.Arrays;

public class Q494TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums==null || nums.length==0)
            return 0;

        int maxValue = 0; // nums[i] in [-maxValue, maxValue], so offset=maxValue. �Ż�Sn
        for (int i = 0; i < nums.length; i++)
            maxValue += nums[i];
        int rangeLen = maxValue*2+1;
        int[] dpCur = new int[rangeLen], dpPrev = new int[rangeLen], dptmp; //�Ż�Sn
        Arrays.fill(dpCur, 0);
        Arrays.fill(dpPrev, 0);
        dpPrev[nums[0]+maxValue] += 1; //***bug: = 1; Error if nums[0]==0
        dpPrev[-nums[0]+maxValue] += 1;
        int curMaxValue = nums[0]; //��֦

        int src1, src2;
        for (int i = 1; i < nums.length; i++) {
            curMaxValue += nums[i];
            for (int j = -curMaxValue; j <= curMaxValue; j++) {
                src1 = j+nums[i]+maxValue; //***bug:û�п��ǵ���Դ��Ч
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
