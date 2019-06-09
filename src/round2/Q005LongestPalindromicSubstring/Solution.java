/**算法分析：
 * 暴力Tn = On^3，使用dp
 *
 * 状态定义：dp[i][j] 为s.substring(i, j+1)是否为回文串, 0 <= i <= j < s.len
 * 转移方程：dp[i][j] =   true, if i==j
 *                      s[i] == s[j], if j-i==1
 *                      s[i] == s[j] && dp[i+1][j-1]==true, if j-i>1
 *
 * */
package round2.Q005LongestPalindromicSubstring;

import java.util.Arrays;

class Solution {
    public String longestPalindrome(String s) {
        if (s==null)
            return null;
        if (s.equals(""))
            return "";

        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++)
            Arrays.fill(dp[i], false);
        // dp
        int maxLen = Integer.MIN_VALUE;
        int maxI = 0, maxJ = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                int dist = j-i;
                if (dist == 0) {
                    dp[i][j] = true;
                } else if (dist == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
                }
                if (dp[i][j] && dist+1>maxLen) {
                    maxLen = dist+1;
                    maxI = i;
                    maxJ = j;
                }
            }
        }

        return s.substring(maxI, maxJ+1);
    }
}