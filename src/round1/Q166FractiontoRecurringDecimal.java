package round1;

import java.util.HashMap;
import java.util.Map;

public class Q166FractiontoRecurringDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator==0)
            return null;
        if (numerator==0)
            return "0";

        long remainder = numerator, divisor = denominator, quotient;
        boolean positive = (remainder > 0 && divisor > 0) || (remainder < 0 && divisor < 0);
        remainder = remainder > 0 ? remainder : -remainder;
        divisor = divisor > 0 ? divisor : -divisor;

        //before decimal point
        StringBuilder sb = new StringBuilder();
        sb.append(remainder / divisor);
        remainder = remainder % divisor*10;
        if (remainder!=0)
            sb.append(".");

        //after decimal point
        Map<Long, Integer> remainders = new HashMap<>(); //remainder, idx
        while (remainder!=0) {
            if (remainders.containsKey(remainder)) {
                sb.insert(remainders.get(remainder), "(");
                sb.append(")");
                break;
            }
            quotient  = remainder / divisor;
            remainders.put(remainder, sb.length());
            remainder = remainder%divisor*10;
            sb.append(quotient );
        }

        if (!positive)
            sb.insert(0, "-");
        return new String(sb);
    }

    public static void main(String[] args) {
        Q166FractiontoRecurringDecimal q = new Q166FractiontoRecurringDecimal();
        int n = 4, d = 333;
        System.out.println(q.fractionToDecimal(n, d));
    }

}
