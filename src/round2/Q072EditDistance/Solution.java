/**算法分析：2d-dp，具体可看round1
 * r1中是从尾到头，这里是从头到尾，本质上是一样的
 * 有一点区别，r1中对边界条件的处理，使用了在dp数组末尾加入空串边界的方法，把空串也纳入dp的范围，简化了初始化
 * 而这里没有把空串纳进来，这里dp[i][j]的定义：word1.substring(0, i+1)与word2.substring(0, j+1)的编辑距离
 * 故这里的边界初始化相对复杂，依然采取的是三种情况的对比，只不过由于 i-1 j-1 都可能越界故需要做特殊处理
 *
 * */

package round2.Q072EditDistance;

class Solution {
    public int minDistance(String word1, String word2) {
        if (word1==null || word2==null)
            return 0;
        if (word1.length()==0 || word2.length()==0)
            return word1.length() == 0 ? word2.length() : word1.length();

        // else: s1 s2 's len >= 1
        int[][] dp = new int[word1.length()][word2.length()];
        dp[0][0] =  ( word1.charAt(0)==word2.charAt(0)?0:1 ) ;
        for (int j = 1; j < word2.length(); j++)
            dp[0][j] = Integer.min( Integer.min(dp[0][j-1]+1, j+1+1), j+(word1.charAt(0)==word2.charAt(j)?0:1) ); //***bug:初始条件依然是三种状态比较，要考虑空串的情况
        for (int i = 1; i < word1.length(); i++)
            dp[i][0] = Integer.min( Integer.min(dp[i-1][0]+1, i+1+1), i+(word1.charAt(i)==word2.charAt(0)?0:1) ); //***bug

        for (int i = 1; i < word1.length(); i++) {
            for (int j = 1; j < word2.length(); j++) {
                dp[i][j] = Integer.min( Integer.min( dp[i-1][j]+1, dp[i][j-1]+1),
                         dp[i-1][j-1]+(word1.charAt(i)==word2.charAt(j)?0:1) );
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}