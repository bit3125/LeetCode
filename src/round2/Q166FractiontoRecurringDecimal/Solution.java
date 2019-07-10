/**round2д��̫������-_-����round1
 *
 * */
package round2.Q166FractiontoRecurringDecimal;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator==0)
            return "";
        if (numerator==0) //***bug
            return "0";

        long num = numerator, den = denominator;
        boolean positive = (num>=0 && den>=0) || ( num<0 && den<0 ) ; //***bug: >=
        num = Math.abs(num);
        den = Math.abs(den);

        StringBuilder sb = new StringBuilder();
        if (!positive) //***bug: add first
            sb.append("-");
        sb.append(String.valueOf(num / den));
        long remainder = num % den;
        if (remainder == 0)
            return new String(sb);

        // else:
        sb.append(".");
        Map<Long, Integer> appear = new HashMap<>(); // remainder, idx
        int curIdx = sb.length(); // ����iterҪ������̵�λ��
        long quotient;
        while (remainder != 0) {
            if (appear.containsKey(remainder)) {
                sb.insert(appear.get(remainder), "(");
                sb.append(")");
                break;
            }
            appear.put(remainder, curIdx); // ���remainder��Ҫ�������quotient��curIdx��

            remainder *= 10;
            quotient = remainder / den;
            remainder %= den;
            sb.append(String.valueOf(quotient));

            curIdx++;
        }

        return new String(sb);
    }
}