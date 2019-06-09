/**�㷨������ʹ��HashSet����ʵ�֣�Tn=On
 * �㷨��Solution1һ����ֻ����ʹ����!set.contains(curNum-1)������Solution1�е�Boolean������ж��Ƿ���ʹ�
 * ��Ч�ʸ��ߡ�
 * ʵ���ϵ�ʱ�俪������һ��������
 *
 * */

package round1;

import java.util.HashSet;
import java.util.Set;

public class Q128LongestConsecutiveSequence_Solution2 {

    public int longestConsecutive(int[] nums) {
        if (nums==null || nums.length==0)
            return 0;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++)
            set.add(nums[i]);


        int maxLen = Integer.MIN_VALUE;
        int curLen = 0;
        for (Integer curNum : set) {
            if (!set.contains(curNum-1)){ //˵��curNum��δ����������������Ϊһ�������еĴ�ͷ
                curLen = 0;
                while(set.contains(curNum)){
                    curNum++;
                    curLen++;
                }
                if (curLen>maxLen)
                    maxLen = curLen;
            }
        }

        return maxLen;
    }

}
