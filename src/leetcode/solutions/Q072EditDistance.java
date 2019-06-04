/**算法分析：二维DP, Tn = O(mn), Sn = O(mn)（可优化为On)
 * 明显需要使用DP来解决的问题（递归复杂度太高）， 与最长公共子序列可对比
 *
 * 以下假定将A修改为B
 * *状态定义*：设dp[i][j]为A.substring(i, A.length())与B.substring(j, B.length())的mindist。（注解：
 * 不考虑[0,i-1][0,j-1]的部分，当做只有目前这两个子串，然后从尾往头不断修改）
 * 则A.substring(A.length(), A.length())与B.substring(B.length(), B.length())表空串。
 * 这个是很重要的边界情况！！故DP矩阵的大小应设置为 (A.length()+1)*(B.length()+1)
 *
 * *状态转移方程*：
 * dp[i][j] = min{ dp[i+1][j+1]+(A[i]==B[j]?0:1), dp[i+1][j]+1, dp[i][j+1]+1 }
 * 分别对应着：  1.修改A[i]为B[j]（若A[i]==B[j]则无需修改，编辑距离+0）
 *              2.删去A[i]
 *              3.在A[i]前插入B[j]
 * 故DP方向为明显的右下角往左上角
 *
 * *初始条件*：
 * dp[A.length()][B.length()] = 0
 * dp[i][B.length()] = dp[i+1][B.length()]+1, 0<=i<=A.length()-1, from buttom to top
 * dp[A.length()][j] = dp[A.length()][j+1]+1, 0<=j<=B.length()-1, from right to left
 * 即初始化矩阵的下边与右边
 *
 * 以上描述的是A修改为B的情况，按常理应该再DP一遍B修改为A的情况，然后return Integer.max(dp1[0][0], dp2[0][0])
 * 但是观察发现上述DP过程是完全对称的，也即dp2 = (dp1)^T (互为转置)
 * 故省去dp2
 *
 * */

package leetcode.solutions;

public class Q072EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1==null || word2==null)
            return 0;

        //init
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        dp[word1.length()][word2.length()] = 0; //俩空串的编辑距离为0
        for (int i = word1.length()-1; i >=0 ; i--)
            dp[i][word2.length()] = dp[i+1][word2.length()]+1;
        for (int j = word2.length()-1; j >=0 ; j--)
            dp[word1.length()][j] = dp[word1.length()][j+1]+1;

        //dp
        for (int i = word1.length()-1; i >= 0; i--)
            for (int j = word2.length()-1; j >= 0; j--)
                dp[i][j] = Integer.min(dp[i+1][j+1]+(word1.charAt(i)==word2.charAt(j)?0:1),
                        Integer.min(dp[i+1][j]+1, dp[i][j+1]+1 ));

        return dp[0][0];
    }
}
