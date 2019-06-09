/**算法分析：使用HashMap，Tn=On
 *
 * 原本打算用数组进行Hash，遍历一遍标记一下，然后再对Hash数组进行遍历，Tn=On
 * 但是由于nums范围为全体整数，故会内存溢出，于是想到使用重量级Hash引入HashMap
 *
 * 将元素put进map后value设置为一个boolean值用于记录其是否在后续遍历的过程中被访问过
 * 由于有类似DFS的visited数组的机制，故虽然从源码中看包含有两个循环，但实际上的Tn=On，
 * 因为遍历过的元素不会再次展开遍历
 *
 * 但是不知为啥明明与Solution2的理论Tn是一样的，结果使用Solution2的HashSet进行实现就是
 * 会比HashMap快上一个数量级，可能是因为HashMap有太多冗余的操作吧
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
