/**�㷨������2d-DP. Tn = O((kn)*n), Sn = O(kn)������kΪelement�����ȡֵ
 *
 * ���ʿɳ���Ϊ������Ƿ����һ�����subset�����㣺sum(subset)==sum(nums)/2
 *
 * upBound = ceil(sum(nums)/2)
 * ״̬���壺dp[i][j] ��ʾǰi������from 0 on, inclusive)���Ƿ���ں�Ϊj���Ӽ�
 * ת�Ʒ��̣�dp[i][j] = dp[i-1][j] || dp[i-1][k], 0<=k=j-nums[i]<=upBound, 0<=i-1<nums.length
 * ��ʼ������1.dp[i][nums[p]]=true, 0<=p<=i
 *          2.others false
 * ��ʵ��ʵ�ֵ�ʱ��ֻҪ����dp[i-1],����dp[i-1][x]=true��ʱ����dp[i][x+nums[i]]=true����
 * ��֮ǰtrue�Ķ���������(ʵ��ֻ��һ��һάdp����,����dp��������������)
 *
 * ��һ�㷨��Tn = O((kn)^2), Sn = O(kn)
 * ����һ��kn����boolean����f����ʾĳ��ȡֵ�Ƿ���ȡ��
 * ����elementsȥ��ʼ����Ӧ��booleanΪtrue
 * Ȼ���ͷ��β����ÿ��ȡֵ��������ϣ�f[i] = ||(f[p] && f[q]), 0<=p<=i && 0<=q<=i && p+q=i
 * ���Ӷȱ�DP����k����deprecate
 *
 *
 * �Ժ󿴵������ص���Կ���ʹ��������DP��
 * 1.�������и���ȡֵ����ϣ����ӶȴﵽO(2^n)��
 * 2.����������ÿ������ȡֵ���ޣ������������鳤�����޵ģ�90%��Ҫ�����������
 * =>ʹ��dp[i][j]����ʾǰi������ĳ�ֺ�ȡ��jֵ��ĳ����
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
        boolean[] dp = new boolean[upBound+1]; //***bug:0Ҳռһ��ȡֵ
        Arrays.fill(dp, false);
        if (nums[0]<=upBound) //***bug:�����ж�Խ��
            dp[nums[0]] = true;

        //dp
        for (int i = 1; i < nums.length; i++) { //***bug:i from 1 on , not from 0 0n
            for (int k = upBound-nums[i]; k >= 0; k--) { //j<=upBound //���ɼ���һ��curUpBound�����Ż�
                //***bug:k����Ҫ�Ӻ���ǰ������ԭ��������д
                int j = k+nums[i];
                if (dp[k] && j<=upBound)  //j��Ȼ������Ϊnums[i]�����Խ�磬����ȥ��
                    dp[j] = true;
            }
            if (nums[i]<=upBound) //***bug:�����ж�Խ��
                dp[nums[i]] = true;//����������ﲻ�ܷ��ڿ�ͷ������������dp[i-1][nums[i]]=true
        }

        return dp[upBound];
    }

    public static void main(String[] args) {
        Q416PartitionEqualSubsetSum q = new Q416PartitionEqualSubsetSum();
        int[] nums = new int[]{2, 2, 3, 5};
        System.out.println(q.canPartition(nums));
    }
}
