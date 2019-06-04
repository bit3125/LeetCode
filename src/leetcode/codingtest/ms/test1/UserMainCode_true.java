package leetcode.codingtest.ms.test1;

import java.util.Arrays;

public class UserMainCode_true {

    public int maxCircles(int input1, int input2, int input3) {
        int n = input1, p = input2, x = input3;
        if (n<0 || p > n || x<0)
            return 0;

        //init mat
        boolean[][] mat = new boolean[n+1][n+1];
        for (int i = 0; i < mat.length; i++) {
            Arrays.fill(mat[i], false);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = i*2; j <=n ; j+=i) { //***bug:j=i
                mat[i][j] = true;
                mat[j][i] = true;
            }
        }

        for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
        return travel(mat, n, x, x, p, p);
    }

    /**
     * left:到目前位置后还能使用的转移次数
     * return:从当前位置下去有几种能回去的方法
     * */
    public int travel(boolean[][] mat, int n, int x, int leftTimes, int p, int curIdx) {
        int cnt = 0;
        if (curIdx==p && leftTimes<x)
            cnt++;
        //else: curIdx!=p
        if (leftTimes <= 0)
            return cnt;

        //else: curIdx!=p && left>0
        for (int i = 1; i <=n ; i++) {
            if (i==curIdx)
                continue;
            //else:
            if (mat[curIdx][i]==true)
                cnt += travel(mat, n, x,leftTimes - 1, p, i);
        }

        return cnt;
    }

    public static void main(String[] args) {
        UserMainCode_true u = new UserMainCode_true();
        int n = 3, p = 2, x = 2;
        System.out.println(u.maxCircles(n, p, x));

    }
}
