/**�㷨������DP
 * ״̬���壺dp[i]Ϊ"�Ӵ�s.substring(0,i+1)(i��β)����Ч�ִ�����󳤶�"
 *          ��ע�⣺����ֱ�Ӷ���Ϊ���Ӵ�s.substring(0,i+1)��**����**����Ч�Ӵ�����󳤶ȡ����������Զ��棬��Ȼ������������
 * ת�Ʒ��̣����� j=i-1-dp[i-1]
 * dp[i] = 1>. 0 , if s[i]=='('
 *         2>. dp[i-1]+2+(j-1>=0?dp[j-1]:0), if s[i]==')' && (j>=0 && s[j]=='(')��
 *         3>. 0, if s[i]==')' && !(j>=0 && s[j]=='(')������ j=i-1-dp[i-1]
 * ��ʼ������dp[0]=0
 * ת�Ʒ��̽��ͣ���'('����ȻΪ0����')'������i-1��β�����Ч�Ӵ���ǰһ���ַ��������ڣ��ܷ񹹳�һ��pair��������Ϊ0���ܵĻ�
 * ��Ҫ��������´�ǰһλ��β�����Ч�Ӵ��ĳ���
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
            //����ľ����
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
