package round1;

import java.util.HashSet;
import java.util.Set;

public class Q202HappyNumber {

    public boolean isHappy(int n) {
        if (n<=0)
            return false;

        Set<Integer> set = new HashSet<>();
        int x;
        while (n!=1) {
            x = n;
            n = 0;
            while (x>0) {
                n += Math.pow((x % 10), 2);
                x /= 10;
            }
            if (set.contains(n))
                return false;
            set.add(n);
        }

        return true;
    }

}
