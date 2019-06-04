package leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q301RemoveInvalidParentheses_Solution2 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> results = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return results;
        }

        boolean[] selected = new boolean[s.length()];
        Arrays.fill(selected, true);


        return results;
    }

    public String removeCore(String s, List<String> results, char[] pars, int parStack) {
        if (false) {//todo
            return null;
        }

        if (s.charAt(0) == pars[0]) {
            removeCore(s, results, pars, parStack);
        }

        if (pars[0] == '(') {
            removeCore(new String(new StringBuffer(s).reverse()), results,
                    new char[]{')','('}, 0 );
        }
        return null;
    }


}
