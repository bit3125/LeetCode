package round1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**算法分析：BruteForce, Tn = On^2, Sn = O1;
 * 穷举所有情况
 * */
public class Q395LongestSubstringwithAtLeastKRepeatingCharacters_Solution1 {

    public int longestSubstring(String s, int k) {
        if (s==null || s.length()==0)
            return 0;

        int[] cnts = new int[26];
        Arrays.fill(cnts, 0);
        Set<Character> appearAndLessThanK = new HashSet<>();
        int maxLen = 0;

        int i = 0, cntIdx;
        char curChar;
        while (i<s.length()) {
            for (int j = i; j < s.length(); j++) { //add j
                curChar = s.charAt(j);
                cntIdx = curChar - 'a';
                cnts[cntIdx]++;
                if (1 == cnts[cntIdx] )  //第一次出现 //***bug:当传入的k为1时的边界情况
                    appearAndLessThanK.add(curChar);
                if (cnts[cntIdx] == k)  //刚达到低保
                    appearAndLessThanK.remove(curChar);

                if (appearAndLessThanK.isEmpty())
                    maxLen = Integer.max(maxLen, j-i+1);
            }

            i++; //remove i
            if (i>=s.length())
                break;
            curChar = s.charAt(i-1);
            cntIdx = curChar - 'a';
            cnts[cntIdx]--;
            if ( k-1 == cnts[cntIdx])  //掉出低保
                appearAndLessThanK.add(curChar);
            if ( 0 == cnts[cntIdx])  //完全消失
                appearAndLessThanK.remove(curChar);
            if (appearAndLessThanK.isEmpty())
                maxLen = Integer.max(maxLen, s.length()-i);

            for (int j = s.length()-1; j >= i; j--) { //remove j
                curChar = s.charAt(j);
                cntIdx = curChar - 'a';
                cnts[cntIdx]--;
                if ( k-1 == cnts[cntIdx])  //掉出低保
                    appearAndLessThanK.add(curChar);
                if ( 0 == cnts[cntIdx])  //完全消失
                    appearAndLessThanK.remove(curChar);

                if (appearAndLessThanK.isEmpty())
                    maxLen = Integer.max(maxLen, j-i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Q395LongestSubstringwithAtLeastKRepeatingCharacters_Solution1 q = new Q395LongestSubstringwithAtLeastKRepeatingCharacters_Solution1();
//        String s = "weitong";
//        int k = 2;
        String s = "a";
        int k = 1;
        System.out.println(q.longestSubstring(s, k));
    }

}
