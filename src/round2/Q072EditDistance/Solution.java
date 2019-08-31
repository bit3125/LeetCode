/**�㷨������2d-dp������ɿ�round1
 * r1���Ǵ�β��ͷ�������Ǵ�ͷ��β����������һ����
 * ��һ������r1�жԱ߽������Ĵ���ʹ������dp����ĩβ����մ��߽�ķ������ѿմ�Ҳ����dp�ķ�Χ�����˳�ʼ��
 * ������û�аѿմ��ɽ���������dp[i][j]�Ķ��壺word1.substring(0, i+1)��word2.substring(0, j+1)�ı༭����
 * ������ı߽��ʼ����Ը��ӣ���Ȼ��ȡ������������ĶԱȣ�ֻ�������� i-1 j-1 ������Խ�����Ҫ�����⴦��
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
            dp[0][j] = Integer.min( Integer.min(dp[0][j-1]+1, j+1+1), j+(word1.charAt(0)==word2.charAt(j)?0:1) ); //***bug:��ʼ������Ȼ������״̬�Ƚϣ�Ҫ���ǿմ������
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