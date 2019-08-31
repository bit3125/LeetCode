/**�㷨������LCS
 * ����DP���̣��ӡ�״̬���塱����ת�Ʒ��̡�������ʼ��������Ҳ�������������״����EditDistance��ֱһëһ����
 * ֻ�о����ϸ�����в�������EditDistance����������
 *
 * ״̬���壺dp[i][j] Ϊ �Ӵ�s1.substring(0, i+1)��s2.substring(0, j+1)�� �����������
 * */

package round2.Q1143LongestCommonSubsequence;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1==null || text2==null || text1.length()==0 || text2.length()==0)
            return 0;

        // init
        int[][] dp = new int[text1.length()][text2.length()];
        dp[0][0] = text1.charAt(0) == text2.charAt(0) ? 1 : 0;
        for (int j = 1; j < dp[0].length; j++)
            dp[0][j] = Integer.max(dp[0][j - 1], text1.charAt(0) == text2.charAt(j) ? 1 : 0);

        // dp
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Integer.max(dp[i - 1][0], text1.charAt(i) == text2.charAt(0) ? 1 : 0);
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Integer.max( Integer.max(dp[i - 1][j], dp[i][j - 1])
                        , dp[i - 1][j - 1] + (text1.charAt(i) == text2.charAt(j) ? 1 : 0) );
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args) {

    }
}