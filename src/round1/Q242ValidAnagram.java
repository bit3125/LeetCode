package round1;

import java.util.HashMap;
import java.util.Map;

public class Q242ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s==null || t==null)
            return false;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i)))
                return false;
            map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
        }

        for (Character c : map.keySet()) {
            if (map.get(c)!=0)
                return false;
        }

        return true;
    }

}
