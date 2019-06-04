/**�㷨��������άDP, Tn = O(mn), Sn = O(mn)�����Ż�ΪOn)
 * ������Ҫʹ��DP����������⣨�ݹ鸴�Ӷ�̫�ߣ��� ������������пɶԱ�
 *
 * ���¼ٶ���A�޸�ΪB
 * *״̬����*����dp[i][j]ΪA.substring(i, A.length())��B.substring(j, B.length())��mindist����ע�⣺
 * ������[0,i-1][0,j-1]�Ĳ��֣�����ֻ��Ŀǰ�������Ӵ���Ȼ���β��ͷ�����޸ģ�
 * ��A.substring(A.length(), A.length())��B.substring(B.length(), B.length())��մ���
 * ����Ǻ���Ҫ�ı߽����������DP����Ĵ�СӦ����Ϊ (A.length()+1)*(B.length()+1)
 *
 * *״̬ת�Ʒ���*��
 * dp[i][j] = min{ dp[i+1][j+1]+(A[i]==B[j]?0:1), dp[i+1][j]+1, dp[i][j+1]+1 }
 * �ֱ��Ӧ�ţ�  1.�޸�A[i]ΪB[j]����A[i]==B[j]�������޸ģ��༭����+0��
 *              2.ɾȥA[i]
 *              3.��A[i]ǰ����B[j]
 * ��DP����Ϊ���Ե����½������Ͻ�
 *
 * *��ʼ����*��
 * dp[A.length()][B.length()] = 0
 * dp[i][B.length()] = dp[i+1][B.length()]+1, 0<=i<=A.length()-1, from buttom to top
 * dp[A.length()][j] = dp[A.length()][j+1]+1, 0<=j<=B.length()-1, from right to left
 * ����ʼ��������±����ұ�
 *
 * ������������A�޸�ΪB�������������Ӧ����DPһ��B�޸�ΪA�������Ȼ��return Integer.max(dp1[0][0], dp2[0][0])
 * ���ǹ۲췢������DP��������ȫ�ԳƵģ�Ҳ��dp2 = (dp1)^T (��Ϊת��)
 * ��ʡȥdp2
 *
 * */

package leetcode.solutions;

public class Q072EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1==null || word2==null)
            return 0;

        //init
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        dp[word1.length()][word2.length()] = 0; //���մ��ı༭����Ϊ0
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
