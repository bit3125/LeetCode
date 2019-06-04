/**�㷨������Tn=?, Sn=On^2
 *
 * ��ʹ������s�����л����Ӵ���dp�㷨��ʹ��dp����ó�s�����еĻ��Ĵ�
 * ʣ�µ��������ʹ��ö�ٻ��ݷ����������������ÿ��ݹ���ʹ��һ��fori���м�֦�Ż�
 * ��Ϊ��Ŀ�����ǡ��õ����еĿ��ܵĽ����������Ҫö�ٵģ���������һ��״̬
 * �ʲ���ʹ��dp������ʹ��ö�ٻ��ݷ�
 *
 * */

package leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q131PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        if (s==null || s.length()==0)
            return results;

        boolean[][] isPal = findPalindrome(s);
        List<String> result = new ArrayList<>();
        partitionCore(s, isPal, results, result, 0);

        return results;
    }

    /**���Ӵ�s.substring(curIdx, s.length)����partition
     * �ܽ������ݹ������˵��s��[0, curIdx-1]�����䶼�Ѿ������˻����Ӵ�
     * �ʵݹ���ھͿ��Ժ����׽綨����
     * */
    private void partitionCore(String s, boolean[][] isPal, List<List<String>> results, List<String> result, int curIdx){
        if (curIdx==s.length()) {
            List<String> finalResult = new ArrayList<>(result); //copy
            results.add(finalResult);
            return;
        }

        for (int end = curIdx; end < s.length(); end++) { //���Խ��Ӵ�s.substring(curIdx, end+1)�зֳ���
            if (isPal[curIdx][end]) {
                result.add(s.substring(curIdx, end + 1));
                partitionCore(s, isPal, results, result, end+1);
                result.remove(result.size() - 1);//backtracking
            }
        }

    }

    private boolean[][] findPalindrome(String s) {
        if (s==null || s.length()==0)
            return null;

        //init
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++)
            Arrays.fill(dp[i], false);
        //dp
        for (int i = s.length()-1; i>=0; i--) {
            for (int j = i; j < s.length(); j++) {
                int dist = j-i;
                dp[i][j] = dist==0?true:(dist==1?(s.charAt(i)==s.charAt(j)):(s.charAt(i)==s.charAt(j)&&dp[i+1][j-1]));
            }
        }

        return dp;
    }

}
