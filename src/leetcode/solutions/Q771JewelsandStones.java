package leetcode.solutions;

import java.util.HashSet;
import java.util.Set;

public class Q771JewelsandStones {
    public int numJewelsInStones(String J, String S) {
        if (J==null || S==null || J.length()==0 || S.length()==0)
            return 0;

        int cnt = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++)
            set.add(J.charAt(i));

        Character c ;
        for (int i = 0; i < S.length(); i++) {
            c = S.charAt(i);
            if (set.contains(c))
                cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        System.out.println((int)'a');
        System.out.println((int)'A');
        System.out.println((int)'Z');
    }

}
