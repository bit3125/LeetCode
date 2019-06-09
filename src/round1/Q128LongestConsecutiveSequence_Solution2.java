/**算法分析：使用HashSet进行实现，Tn=On
 * 算法与Solution1一样，只不过使用了!set.contains(curNum-1)来代替Solution1中的Boolean标记来判断是否访问过
 * ，效率更高。
 * 实际上的时间开销少了一个数量级
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
            if (!set.contains(curNum-1)){ //说明curNum尚未被遍历过，可以作为一个新序列的打头
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
