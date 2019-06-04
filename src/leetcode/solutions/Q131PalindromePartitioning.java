/**算法分析：Tn=?, Sn=On^2
 *
 * 先使用搜索s中所有回文子串的dp算法，使用dp矩阵得出s中所有的回文串
 * 剩下的事情就是使用枚举回溯法进行逐个搜索，在每层递归中使用一个fori进行剪枝优化
 * 因为题目类型是“得到所有的可能的结果”，是需要枚举的，并不是求一个状态
 * 故不能使用dp，必须使用枚举回溯法
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

    /**将子串s.substring(curIdx, s.length)进行partition
     * 能进入这层递归调用则说明s的[0, curIdx-1]闭区间都已经构成了回文子串
     * 故递归出口就可以很容易界定出来
     * */
    private void partitionCore(String s, boolean[][] isPal, List<List<String>> results, List<String> result, int curIdx){
        if (curIdx==s.length()) {
            List<String> finalResult = new ArrayList<>(result); //copy
            results.add(finalResult);
            return;
        }

        for (int end = curIdx; end < s.length(); end++) { //尝试将子串s.substring(curIdx, end+1)切分出来
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
