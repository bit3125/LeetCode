package others.codingtest;

import java.util.Arrays;

public class Solution2 {

    int edit(int a, int b) {//a<b
        int[][] cache = new int[b*2*2][b+1];
        for (int i = 0; i < cache.length; i++) {
            Arrays.fill(cache[i], Integer.MAX_VALUE);
        }
        return editCore(a, b, cache);

    }

    int editCore(int a, int b, int[][] cache) { //a<b
        if (a>cache.length-1 || a<=0) //out of bound
            return Integer.MAX_VALUE;
        if (a == b) { //µÝ¹é³ö¿Ú
            cache[a][b] = 0;
            return 0;
        }

        int cnt = Integer.MAX_VALUE;
        cnt = Integer.min(a+1>a?(cache[a+1][b]==Integer.MAX_VALUE?editCore(a + 1, b, cache):cache[a+1][b]):Integer.MAX_VALUE, a-1>0?( cache[a-1][b]==Integer.MAX_VALUE?editCore(a - 1, b, cache):cache[a-1][b] ):Integer.MAX_VALUE);
        cnt = Integer.min(cnt, a << 1 > a ? ( cache[a<<1][b]==Integer.MAX_VALUE?editCore(a << 1, b, cache):cache[a<<1][b] ) : Integer.MAX_VALUE);
        cache[a][b] = cnt;

        return cnt;
    }

    public static void main(String[] args) {
        int a = 5, b = 8;
        Solution2 q = new Solution2();
        System.out.println(q.edit(a, b));


    }
}
