/**做完想起来是剑指offer原题
 * 写太复杂了还用HashMap
 *
 * */
package leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

public class Q387FirstUniqueCharacterinaString_Solution1 {

    public int firstUniqChar(String s) {
        if (s==null || s.length()==0)
            return -1;

        Map<Character, Integer> map = new HashMap<>();
        Integer idx ;
        Character c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            idx = map.get(c);
            if (idx != null) { //used to appear
                map.put(c, -1);
            } else  //never appears
                map.put(c, i);
        }

        int minIdx = Integer.MAX_VALUE;
        for (Character cc : map.keySet()) {
            idx = map.get(cc);
            if ( idx!=-1 && idx<minIdx)
                minIdx = idx;
        }
        return minIdx==Integer.MAX_VALUE?-1:minIdx;
    }

}
