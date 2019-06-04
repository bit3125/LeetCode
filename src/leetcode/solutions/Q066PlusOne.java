package leetcode.solutions;

import java.util.Arrays;

public class Q066PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits==null || digits.length==0)
            return digits;

        int carry = 1;
        for (int i = digits.length-1; i >= 0; i--) {
            digits[i] += carry;
            carry = digits[i]/10;
            digits[i] %= 10;
        }
        if (carry == 1) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            digits = newDigits;
        }

        return digits;
    }
}
