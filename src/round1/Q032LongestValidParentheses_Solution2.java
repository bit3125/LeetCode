/**算法分析：DP
 * 状态定义：dp[i]为"子串s.substring(0,i+1)(i结尾)的有效字串的最大长度"
 *          （注意：不能直接定义为“子串s.substring(0,i+1)中**包含**的有效子串的最大长度”，否则难以动规，虽然这是最终所求）
 * 转移方程：其中 j=i-1-dp[i-1]
 * dp[i] = 1>. 0 , if s[i]=='('
 *         2>. dp[i-1]+2+(j-1>=0?dp[j-1]:0), if s[i]==')' && (j>=0 && s[j]=='(')，
 *         3>. 0, if s[i]==')' && !(j>=0 && s[j]=='(')，其中 j=i-1-dp[i-1]
 * 初始条件：dp[0]=0
 * 转移方程解释：若'('则自然为0，若')'则看其与i-1结尾的最长有效子串的前一个字符（若存在）能否构成一个pair，不能则为0，能的话
 * 则还要加上这个新串前一位结尾的最长有效子串的长度
 * */

package round1;

public class Q032LongestValidParentheses_Solution2 {

    public int longestValidParentheses(String s) {
        if (s==null || s.length()==0)
            return 0;

        int[] dp = new int[s.length()];
        dp[0] = 0;
        int maxLen = dp[0];

        for (int i = 1; i < dp.length; i++) {
//            if (s.charAt(i) == '(') {
//                dp[i] = 0;
//            }else{ //==')'
//                int j = i-1-dp[i-1];
//                if (j >= 0 && s.charAt(j) == '(') {
//                    dp[i] = dp[i-1]+2+(j-1>=0?dp[j-1]:0);
//                }else
//                    dp[i] = 0;
//            }
            //上面的精简版
            int j = i-1-dp[i-1];
            if (s.charAt(i) == ')' && j >= 0 && s.charAt(j) == '(') {
                dp[i] = dp[i-1]+2+(j-1>=0?dp[j-1]:0);
            }else //==')'
                dp[i] = 0;

            if (dp[i]>maxLen)
                maxLen = dp[i];
        }

        return maxLen;
    }

}
