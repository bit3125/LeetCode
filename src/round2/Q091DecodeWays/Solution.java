/**算法分析
 * 状态定义：dp[i]为 子串s.substring(0, i+1)的解码种类数
 * 转移方程：dp[i] = dp[i-1] + 1<=s.substring(i-1, i+1)<=26?dp[i-2]:0
 *
 * */

package round2.Q091DecodeWays;

import java.util.Arrays;

class Solution {
    public int numDecodings(String s) {
        if (s==null || s.length()==0)
            return 0;

        int[] dp = new int[s.length()];
        Arrays.fill(dp, 0);
        dp[0] = s.charAt(0)=='0'?0:1;
        for (int i = 1; i < s.length(); i++) {
            dp[i] = ( inRange(s.substring(i, i+1))?dp[i-1]:0 )
                    + ( inRange(s.substring(i-1, i+1))?(i-2>=0?dp[i-2]:1):0 );
        }

        return dp[dp.length-1];
    }

    private boolean inRange(String sub) {
        if (sub.charAt(0)=='0') //***bug:forget
            return false;
        int num = Integer.valueOf(sub);
        return 1<=num && num<=26;
    }
}