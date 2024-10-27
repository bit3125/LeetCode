package round4.q097InterleavingString;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null) {
            return s1 == null ? s2.equals(s3) : s1.equals(s3);
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        Map<String, Boolean> resCache = new HashMap<>();
        return core(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), 0, 0, 0, resCache);
    }

    public boolean core(char[] c1, char[] c2, char[] c3, int idx1, int idx2, int idx3, Map<String, Boolean> resCache) {
        if (idx3 == c3.length) {
            return idx1 == c1.length && idx2 == c2.length;
        }
        String cacheKey = getCacheKey(idx1, idx2);
        if (resCache.containsKey(cacheKey)) {
            return resCache.get(cacheKey);
        }

        boolean isInterleave = false;
        // else: idx3 < c3.length
        if (idx1 == c1.length || idx2 == c2.length) {
            isInterleave = idx1 == c1.length ? isEqualCharArr(c2, c3, idx2, idx3) : isEqualCharArr(c1, c3, idx1, idx3);
            resCache.put(cacheKey, isInterleave);
            return isInterleave;
        }

        // else: idx3 < c3.length && idx1 < c1.length && idx2 < c2.length
        if (idx1 < c1.length && c1[idx1] == c3[idx3]) {
            isInterleave = core(c1, c2, c3, idx1 + 1, idx2, idx3 + 1, resCache);
        }
        if (!isInterleave && idx2 < c2.length && c2[idx2] == c3[idx3]) {
            isInterleave = core(c1, c2, c3, idx1, idx2 + 1, idx3 + 1, resCache);
        }
        resCache.put(cacheKey, isInterleave);
        return isInterleave;
    }

    public boolean isEqualCharArr(char[] c1, char[] c2, int idx1, int idx2) {
        if (c1.length - idx1 != c2.length - idx2) {
            return false;
        }

        while (idx1 < c1.length) {
            if (c1[idx1] != c2[idx2]) {
                return false;
            }
            idx1++;
            idx2++;
        }

        return true;
    }

    public String getCacheKey(int i, int j) {
        return i + "-" + j;
    }
    public static void main(String[] args) {
        Solution sl = new Solution();
        String s1 = "abababababababababababababababababababababababababababababababababababababababababababababababababbb";
        String s2 = "babababababababababababababababababababababababababababababababababababababababababababababababaaaba";
        String s3 = "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababbb";
        System.out.println(sl.isInterleave(s1, s2, s3));
    }
}