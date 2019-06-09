package round1;

public class Q461HammingDistance {
    public int hammingDistance(int x, int y) {
        if (x < 0 || y < 0)
            return 0;

        return cntOneBits(x^y);
    }

    public int cntOneBits(int n) {
        int cnt = 0;
        while (n != 0) {
            n &= n-1;
            cnt++;
        }
        return cnt;
    }
}
