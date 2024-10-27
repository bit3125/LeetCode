package round4.q022GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        if (n <= 0) {
            return results;
        }

        char[] str = new char[2 * n];
        core(results, str, 0, n, 0, 0);
        return results;
    }

    private void core(List<String> results, char[] cs, int pos, int n, int leftCnt, int rightCnt) {
        if (pos == cs.length) {
            results.add(new String(cs));
            return;
        }

        // left
        if (leftCnt < n) {
            cs[pos] = '(';
            core(results, cs, pos + 1, n, leftCnt + 1, rightCnt);
        }
        // right
        if (rightCnt < leftCnt) {
            cs[pos] = ')';
            core(results, cs, pos + 1, n, leftCnt, rightCnt + 1);
        }
    }
}
