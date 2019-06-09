package round1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**算法分析：理论上应该是这样？ Tn = Onlogn （最坏肯定是On^2）, Sn = O(logn)。但是实际上效果拔群。。不知道为啥
 *
 * 找出当前子串中没达标k的字符，以此为分隔符分割出若干子串，然后递归统计。
 * */
public class Q395LongestSubstringwithAtLeastKRepeatingCharacters_Solution2 {

    public int longestSubstring(String s, int k) {
        if (s==null || s.length()==0)
            return 0;

        return longestSubstring(s.toCharArray(), k, 0, s.length());
    }

    public int longestSubstring(char[] s, int k, int start, int end) {
        if (end-start<k) //***bug:start>=end 剪枝递归出口
            return 0;

        //cnt
        int[] cnts = new int[26];
        Arrays.fill(cnts, 0);
        for (int i = start; i < end; i++)
            cnts[s[i] - 'a']++;

        //***bug:stackOverFlow, 这里才是真正的递归出口
        int appearAndLessThanK = 0;
        for (int i = 0; i < 26; i++)
            if (cnts[i]!=0 && cnts[i]<k)
                appearAndLessThanK++;
        if (appearAndLessThanK==0)
            return end-start;

        int maxLen = 0;
        int front = start, rear = start;
        while (rear<=end) {
            if (rear == end || cnts[s[rear] - 'a'] < k) { //注意这里的rear==end，同时处理了末尾剩余的情况。同时影响了while的判断条件
                maxLen = Integer.max(maxLen, longestSubstring(s, k, front, rear));
                front = rear+1;
            }
            rear++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "aaabb";
        int k = 3;
        Q395LongestSubstringwithAtLeastKRepeatingCharacters_Solution2 q = new Q395LongestSubstringwithAtLeastKRepeatingCharacters_Solution2();

        System.out.println(q.longestSubstring(s, k));
    }

}
