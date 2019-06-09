/**
 *
 * */
package round1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q387FirstUniqueCharacterinaString_Solution2 {

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0)
            return -1;

        int[] cnts = new int[26];
        Arrays.fill(cnts, 0);

        for (int i = 0; i < s.length(); i++)
            cnts[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (cnts[s.charAt(i) - 'a']==1)
                return i;
        }

        return -1;
    }

}
