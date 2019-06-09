package round2.Q049GroupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs==null || strs.length==0)
            return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        List<String> curList;
        String curKey;
        // sort
        for (int i = 0; i < strs.length; i++) {
            curKey = getSetKey(strs[i]);
            curList = map.getOrDefault(curKey, new ArrayList<>());

            curList.add(strs[i]);
            map.put(curKey, curList);
        }

        return new ArrayList<>(map.values());
    }

    private String getSetKey(String str) {
        if (str == null)
            return null;
        //init
        int[] cnts = new int[26];
        for (int i = 0; i < cnts.length; i++)
            cnts[i] = 0;
        //cnt
        for (int i = 0; i < str.length(); i++)
            cnts[str.charAt(i)-'a']++;
        //join key. 这里写的太麻烦了 看round1Solution3，直接使用Arrays.toString简单粗暴。。
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < cnts.length; i++)
            key.append( (char)(i+'a')+String.valueOf(cnts[i]) );
        return new String(key);
    }

}