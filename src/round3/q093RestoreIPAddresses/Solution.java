package round3.q093RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

//TODO: 对着标准Solution消化一下
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return result;
        }

        StringBuilder sb = new StringBuilder(s.length() + 4);
        core(s, 0, sb, 0, 0, result);
        return result;
    }

    public void core(String s, int sIdx, StringBuilder sb, int sbIdx, int curNumCnt, List<String> result) {
        if (sIdx >= s.length() || curNumCnt == 4) { // 满足其一则到达递归边界(继续递归可能越界)
            if (sIdx == s.length() && curNumCnt == 4) { // 同时满足才合法
                result.add(sb.substring(0, sbIdx - 1/** rm the latest dot*/));
            }

            // else: must fail
            return;
        }

        // visit
        String subStr;
        for (int i = 1; i <= 3; i++) {
            if (sIdx + i > s.length()) {
                break; // illegal, fast return
            }

            subStr = s.substring(sIdx, sIdx + i);
            if (isValid(subStr)) {
                sb.replace(sbIdx, sbIdx + i, subStr);
                sb.replace(sbIdx + i, sbIdx + i + 1, ".");
                core(s, sIdx + i, sb, sbIdx + i + 1, curNumCnt + 1, result);
            }
        }
    }

    public boolean isValid(String s) {
        if (s == null || s.isEmpty() || s.length() > 3) {
            return false;
        }
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }

        int num = Integer.parseInt(s);
        return 0 <= num && num <= 255;
    }
}