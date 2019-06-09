package others.codingtest;

public class Solution {

    long lastNotZero(int n) {
        if (n==0)
            return 1;
        return lastNotZeroCore(n)%10;
    }

    long lastNotZeroCore(int n){

        int[] GN = new int[]{6,6,2,6,4,4,4,8,4,6};
        int[] GT = new int[]{6,2,4,8};
        int[] G = new int[]{0,1,2,6,4};

        if (n<5)
            return G[n];

        return GN[n%10]*GT[n/5*3%4]%10* lastNotZeroCore(n/5);
    }

    public static void main(String[] args) {
        int n = 10000009;
        Solution q = new Solution();
        System.out.println(q.lastNotZero(n));
    }
}
