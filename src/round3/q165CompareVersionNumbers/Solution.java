package round3.q165CompareVersionNumbers;

class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null || version1.isEmpty() || version2.isEmpty()) {
            return 0;
        }

        String[] strs1, strs2;
        strs1 = version1.split("\\.");
        strs2 = version2.split("\\.");
        int v1, v2, result;
        int len = Integer.max(strs1.length, strs2.length);

        for (int i = 0; i < len; i++) {
            v1 = i < strs1.length ? parseInt(strs1[i]) : 0;
            v2 = i < strs2.length ? parseInt(strs2[i]) : 0;

            result = Integer.compare(v1, v2);
            if (result != 0) {
                return result;
            }
        }

        return 0;
    }

    public int parseInt(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
            sum *= 10;
        }

        return sum;
    }
}