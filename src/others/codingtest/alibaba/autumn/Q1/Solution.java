/**
 * ×ªÒÆ·½³Ì£ºdp[i][j] = min{dp[i][j-2]+area[i][j-1], dp[i-2][j]+area[i-1][j]}
 *
 * */

package others.codingtest.alibaba.autumn.Q1;

import java.util.Arrays;

public class Solution {

    private static int getMinimumTimeCost(int n, int[][] area) {
        if (n<0 || area==null || area.length==0)
            return Integer.MAX_VALUE;

        // init
        int[][] dp = new int[area.length][area[0].length];
        for (int i = 0; i < area.length; i++) {
            Arrays.fill(dp[i], 0);
        }

        // dp
        for (int i = 2; i < area.length; i+=2) {
            for (int j = 0; j < area[0].length; j++) {
                dp[i][j] = Integer.min(j-2>=0?(dp[i][j-2]+area[i][j-1]):Integer.MAX_VALUE,
                        i-2>=0?(dp[i-2][j]+area[i-1][j]):Integer.MAX_VALUE);
            }
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        int minValue = Integer.MAX_VALUE;
        // odd return
        if ( (area.length & 1)==1 ){
            for (int i = 0; i < area[0].length; i++) {
                minValue = Integer.min(minValue, dp[dp.length-1][i]);
            }
        } else{
            // even return
            for (int i = 0; i < area[0].length; i++) {
                minValue = Integer.min(minValue, dp[dp.length-2][i]+area[area.length-1][i]);
            }
        }
        return minValue;
    }

    public static void main(String[] args) {
//        int[][] area = new int[][]{
//                {1,2,3,5,7,6},
//                {2,1,4,5,7,4},
//                {3,4,5,6,3,6},
//                {2,3,1,4,6,8},
//                {5,6,1,4,6,2},
//                {4,2,4,1,1,6}};
//        int n = 6;
        int[][] area = new int[][]{
                {1,2,3,5,7},
                {2,1,4,5,7},
                {3,4,5,6,3},
                {2,3,1,4,6},
                {5,6,1,4,6}
        };
        int n = 5;

        System.out.println("rest"+getMinimumTimeCost(n, area));

    }
}
