package round4.q008StringtoInteger;

class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int sign, idx = 0, sum = 0, digit;

        // remove leading spaces
        while (idx < s.length() && s.charAt(idx) == ' ') {
            idx++;
        }

        // determine the sign
        //***BUG: check idx < s.length()
        if (idx < s.length() && s.charAt(idx) == '-') {
            sign = -1;
            idx++;
        } else if (idx < s.length() && s.charAt(idx) == '+') {
            sign = 1;
            idx++;
        } else {
            sign = 1;
        }

        // skip leading zeros
        while (idx < s.length() && s.charAt(idx) == '0') {
            idx++;
        }

        // cal
        while (idx < s.length() && isDigitChar(s.charAt(idx))) {
            digit = s.charAt(idx) - '0';
            //***BUG: 可用这种方式，在每次扩容计算前预比较一下sum是否越界
            if (sum > Integer.MAX_VALUE / 10 || sum == Integer.MAX_VALUE / 10 && digit >= 8) { // the new sum's abs >= 2^31
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            sum = sum * 10 + digit;
            idx++;
        }

        return sum * sign;
    }

    private boolean isDigitChar(char c) {
        return '0' <= c && c <= '9';
    }
}