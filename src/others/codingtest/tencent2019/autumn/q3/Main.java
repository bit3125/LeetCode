package others.codingtest.tencent2019.autumn.q3;

import java.util.Scanner;

public class Main {

//    public static void main(String[] args) {
//        int[] array = new int[]{5, 9, 4, 7};
////        int[] array = new int[]{9,13,18,10,12,4,18,3};
//
//        System.out.println(Arrays.toString(split(array)));
//    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int n ;
        while (t > 0) {
            n = in.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++)
                array[i] = in.nextInt();

            int[] results = split(array);
            System.out.println(results[0]+" "+results[1]);

            t--;
        }

    }

    public static int[] split(int[] array) {
        int sum = 0;
        for (int a : array)
            sum += a;

        return splitMain(array, sum);
    }

    public static int[] splitMain(int[] array, int sum) {
        int half = sum / 2;
        int n = array.length;
        int[][] dp = new int[n / 2 + 1][half + 1];

        for (int i = 1; i <= n; i++) {
            int nLimit = Integer.min(i, n / 2);
            for (int j = nLimit; j >= 1; j--) {
                for (int k = array[i-1]; k <= half; k++) {
                    if (dp[j][k] < dp[j - 1][k - array[i - 1]] + array[i - 1]) {
                        dp[j][k] = dp[j - 1][k - array[i - 1]] + array[i - 1];
                    }
                }
            }

        }

        int a = dp[n / 2][half], b = sum - a;
        int[] results = new int[]{a, b};
        return results;
    }

}
