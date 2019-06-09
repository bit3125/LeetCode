package round2.Q387FirstUniqueCharacterinaString;

class Solution {
    public int firstUniqChar(String s) {
        if (s==null)
            return -1;

        int[] appear = new int[26];
        for (int i = 0; i < appear.length; i++)
            appear[i] = 0;
        for (int i = 0; i < s.length(); i++)
            appear[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (appear[s.charAt(i) - 'a']==1)
                return i;
        }

        return -1;
    }
}