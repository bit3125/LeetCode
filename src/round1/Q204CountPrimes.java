package round1;

import java.util.Arrays;

public class Q204CountPrimes {

    public int countPrimes(int n) {
        if (n<=2)
            return 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i < Math.sqrt(n)+1; i++) {
            if (!isPrime[i]) //key
                continue;
            for (int j = i*i ; j < n; j += i) {
                isPrime[j] = false;
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (isPrime[i])
                cnt++;
        }

        return cnt;
    }


}
