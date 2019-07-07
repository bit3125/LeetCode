/**算法分析：
 * 状态定义：dp[i] 为s.substring(0, i)是否能满足word break
 * 转移方程：dp[i] = ||( (k==-1 || (k>=0 && dp[k]) ) && s.substring(k+1, i+1)), k = i-dict[j].len, 0<=j<dict.size()
 * 初始条件：
 *
 * 考虑的意外情况: wordDict中包含有空串""
 *
 * */

package round2.Q139WordBreak;

import java.util.Arrays;
import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s==null || wordDict==null || s.length()==0 )
            return false;

        boolean[] dp = new boolean[s.length()];
        Arrays.fill(dp, false);
        int prevDpIdx;
        String curStr;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                curStr = wordDict.get(j);
                prevDpIdx = i-curStr.length();
                if (  ( prevDpIdx == -1 || (prevDpIdx>=0 && dp[prevDpIdx]) )
                        && s.substring(prevDpIdx + 1, i + 1).equals(curStr)) {
                    dp[i] = true;
                    break;
                } // else: continue
            }
        }
        return dp[dp.length-1];
    }
}