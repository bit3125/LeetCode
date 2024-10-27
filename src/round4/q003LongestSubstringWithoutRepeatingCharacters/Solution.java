package round4.q003LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        int[] dp = new int[s.length()]; // ��s[i]��β������ظ��ַ��ִ�, ��ʼλ��idx
        dp[0] = 0;
        Map<Character, Integer> latestIdxes = new HashMap<>(); // ��������ǰλ����, �ַ�c���ֵ����λ��
        latestIdxes.put(s.charAt(0), 0);
        int max = 1;
        for (int i = 1; i < s.length(); i++) {
            int latestIdx = latestIdxes.getOrDefault(s.charAt(i), -1);
            if (latestIdx < dp[i - 1]) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = latestIdx + 1;
            }

            latestIdxes.put(s.charAt(i), i);
            max = Integer.max(max, i - dp[i] + 1);
        }

        return max;
    }
}