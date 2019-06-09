/**�㷨������ʹ��HashMap��Tn=On
 *
 * ԭ���������������Hash������һ����һ�£�Ȼ���ٶ�Hash������б�����Tn=On
 * ��������nums��ΧΪȫ���������ʻ��ڴ�����������뵽ʹ��������Hash����HashMap
 *
 * ��Ԫ��put��map��value����Ϊһ��booleanֵ���ڼ�¼���Ƿ��ں��������Ĺ����б����ʹ�
 * ����������DFS��visited����Ļ��ƣ�����Ȼ��Դ���п�����������ѭ������ʵ���ϵ�Tn=On��
 * ��Ϊ��������Ԫ�ز����ٴ�չ������
 *
 * ���ǲ�֪Ϊɶ������Solution2������Tn��һ���ģ����ʹ��Solution2��HashSet����ʵ�־���
 * ���HashMap����һ������������������ΪHashMap��̫������Ĳ�����
 * */

package round1;

import java.util.HashMap;
import java.util.Map;

public class Q128LongestConsecutiveSequence_Solution1 {

    public int longestConsecutive(int[] nums) {
        if (nums==null || nums.length==0)
            return 0;

        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], false);

        int maxLen = Integer.MIN_VALUE;
        int curLen=0;
        for (Integer curNum : map.keySet()) {
            if (map.get(curNum)==false){
                curLen = 0;
                while(map.containsKey(curNum)){
                    map.put(curNum, true);
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
