/**�㷨������Tn = On^2, BruteForce��Tn=On^3,
 * �����ö��������Ż�����Ϊelement����Ϊ��
 *
 * */

package round1;

public class Q560SubarraySumEqualsK_Solution1 {
    public int subarraySum(int[] nums, int k) {
        if (nums==null || nums.length==0)
            return 0;

        //init
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i-1] + nums[i];
        }

        //body
        int curSum;
        int cnt = 0;
        for (int i = 0; i < sums.length; i++)
            if (sums[i]==k)
                cnt++;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                curSum = sums[j] - sums[i];
                if (curSum == k) //***bug:û���ǵ�element<=0����ʹ����break
                    cnt++;
            }
        }
        return cnt;
    }
}
