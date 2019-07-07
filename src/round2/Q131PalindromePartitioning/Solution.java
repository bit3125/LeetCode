package round2.Q131PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        List<String> result = new ArrayList<>();
        if (s==null || s.length()==0)
            return results;
        if (s.equals("")) {
            result.add("");
            results.add(result);
            return results;
        }

        boolean[][] dp = longestPalindrome(s);
        helper(s, dp, results, result, 0);

        return results;
    }

    private void helper(String s, boolean[][] dp, List<List<String>> results, List<String> result, int startIdx) {
        if (startIdx == s.length()) {
            results.add(new ArrayList<>(result));
            // backtracking & return at tail
        }else{
            for (int endIdx = s.length()-1; endIdx >=startIdx ; endIdx--) { //[,]
                if (dp[startIdx][endIdx]) {
                    result.add(s.substring(startIdx, endIdx + 1));
                    helper(s, dp, results, result, endIdx+1);
                }
            }
        }

        if (result.size()>0) //***bug
            result.remove(result.size() - 1); // tail backtracking
    }

    public boolean[][] longestPalindrome(String s) {
        if (s==null || s.length()==0)
            return null;

        boolean[][] f = new boolean[s.length()][s.length()];

        //cal
        for (int i=f.length-1;i>=0;i--)
            for (int j=i;j<f.length;j++)
                f[i][j] = i==j
                        || ( j-i==1 && s.charAt(i)==s.charAt(j) )
                        || (f[i+1][j-1] && s.charAt(i)==s.charAt(j));

        return f;
    }
}
