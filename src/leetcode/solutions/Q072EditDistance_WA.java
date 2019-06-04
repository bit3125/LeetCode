/**算法分析：空串的情况没考虑清楚，是个WA答案
 *
 * */

package leetcode.solutions;

public class Q072EditDistance_WA {
    public int minDistance(String word1, String word2) {
        if (word1==null || word2==null)
            return 0;
        else if (word1.length() == 0 || word2.length() == 0) //***bug:没考虑周全空串的情况
            return Integer.max(word1.length(), word2.length());

        //init
        int[][] dp = new int[word1.length()][word2.length()];
        dp[0][0] = word1.charAt(0) == word2.charAt(0)?0:1;
        for (int i = 1; i < word1.length(); i++)
            dp[i][0] = dp[i-1][0]+1;
        for (int j = 1; j < word2.length(); j++)
            dp[0][j] = dp[0][j-1]+1;

        //dp
        for (int i = 1; i < word1.length(); i++)
            for (int j = 1; j < word2.length(); j++)
                dp[i][j] = Integer.min(dp[i-1][j-1]+(word1.charAt(i)==word2.charAt(j)?0:1),
                        Integer.min(dp[i-1][j]+1, dp[i][j-1]+1 ));

        return dp[word1.length()-1][word2.length()-1];
    }
}
