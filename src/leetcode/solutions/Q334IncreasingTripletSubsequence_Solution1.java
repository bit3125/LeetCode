package leetcode.solutions;

import java.util.Arrays;

/**�㷨����������ΪѰ�ҡ�����������С���Tn = On^2, Sn = On��û�дﵽ����On,O1��Ҫ��
 * ״̬���壺dp[i]Ϊ��nums[i]��β������������еĳ���
 * ״̬ת�Ʒ��̣�dp[i] = max{dp[j]+1, 1}, where 0<=j<i && nums[j]<nums[i]
 *
 * */
public class Q334IncreasingTripletSubsequence_Solution1 {

    public boolean increasingTriplet(int[] nums) {
        if (nums==null || nums.length<3)
            return false;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) { //cal dp[i]
            for (int j = 0; j < i; j++) { //traverse dp[0]~dp[i]
                if (nums[j] < nums[i])
                    dp[i] = Integer.max(dp[i], dp[j] + 1);
                if (dp[i]>=3)
                    return true;
            }
        }

        return false;
    }

}
