/**�㷨������Tn = On, BruteForce��Tn=On^3,
 *
 * ������preSum�󣬱���ת��Ϊ��TwoSum��ͬ�����⣺Ѱ��preSum����������������ϣ�ʹ�����ֵΪk
 * �ʿ�ʹ��HashMap�����Ż�
 * */

package round1;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q560SubarraySumEqualsK_Solution2 {
    public int subarraySum(int[] nums, int k) {
        if (nums==null || nums.length==0)
            return 0;

        //init
        Map<Integer, List<Integer>> map = new HashMap<>(); //<presum, list:{idx1, idx2...}>
        int[] sums = new int[nums.length+1]; //sums[i]��ʾ������(-1,i)�ĺ�
        sums[0] = 0;
        List<Integer> tmpList = new ArrayList<>();
        tmpList.add(0);
        map.put(sums[0], tmpList);
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i-1] + nums[i-1];
            if (!map.containsKey(sums[i]))
                map.put(sums[i], new ArrayList<>());
            map.get(sums[i]).add(i);
        }

        int cnt = 0;
        for (int i = 0; i < sums.length; i++) {
            List<Integer> targetList = map.get(k+sums[i]); //t-i=k
            if (targetList==null)
                continue; //***bug:break;
            for (int j = 0; j < targetList.size(); j++) {
                if (targetList.get(j) > i)
                    cnt++;
            }
        }

        return cnt;
    }
}
