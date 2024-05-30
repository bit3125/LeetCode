package round3.q022GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }

        StringBuilder sb = new StringBuilder();
        core(n, 0, 0, 0, sb, result);

        return result;
    }

    public void core(int n, int usedLeftParCnt/** used for trimming*/, int leftLeftParCnt, int curIdx, StringBuilder sb, List<String> result) {
        if (curIdx == 2 * n) { // arrive
            if (leftLeftParCnt == 0) {
                result.add(sb.toString());
            }

            return;
        }

        if (usedLeftParCnt < n) { // ensure that it must be legal to call the next recursion
            sb.replace(curIdx, curIdx + 1, "(");
            core(n, usedLeftParCnt + 1, leftLeftParCnt + 1, curIdx + 1, sb, result);
        }
        if (leftLeftParCnt > 0) { // ensure that it must be legal to call the next recursion
            sb.replace(curIdx, curIdx + 1, ")");
            core(n, usedLeftParCnt, leftLeftParCnt - 1, curIdx + 1, sb, result);
        }
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        List<String> l = sl.generateParenthesis(4);
        System.out.println(l);
    }
}