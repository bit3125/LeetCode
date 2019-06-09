/**算法分析：
 *
 * 状态定义：dp[i] 为以i结尾的最长无重复子串长度
 *
 * */
package round2.Q003LongestSubstringWithoutRepeatingCharacters;

import java.util.Arrays;

class Solution {
    int MAX_CHAR_NUM = 256;

    public int lengthOfLongestSubstring(String s) {
        if (s==null || s.length()==0)
            return 0;

        int[] dp = new int[s.length()];
        int[] lastAppearIdxs = new int[MAX_CHAR_NUM];
        Arrays.fill(dp, 1);
        Arrays.fill(lastAppearIdxs, -1);
        lastAppearIdxs[s.charAt(0)] = 0; //***bug:from 1 on. forget to init lastAppearIdxs[0]

        //dp
        int maxLen = dp[0];
        int prevSubstrStartIdx;
        for (int i = 1; i < s.length(); i++) {
            prevSubstrStartIdx = i - dp[i - 1];
            if (lastAppearIdxs[s.charAt(i)] < prevSubstrStartIdx) {
                dp[i] = dp[i - 1] + 1;
            } else // lastAppearIdxs[s.charAt(i)] >= prevSubstrStartIdx
                dp[i] = i - lastAppearIdxs[s.charAt(i)];

            lastAppearIdxs[s.charAt(i)] = i;
            maxLen = Integer.max(maxLen, dp[i]);
        }

        return maxLen;
    }

}