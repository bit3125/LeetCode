package others.codingtest.tencent2019.autumn.q3.give;

import java.util.Arrays;
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
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
            }

            int[] results = func(array);
            System.out.println(results[0]+" "+results[1]);

            t--;
        }

    }

    public static int[] func(int[] array) {
        int nLen = array.length;
        int Sum = 0;

        for (int i = 0; i < array.length; i++) {
            Sum += array[i];
        }

        return core(array, nLen, Sum);
    }

    public static int[] core(int[] array, int nLen, int Sum) {
        int nToBeClosed = Sum / 2;
        int[][] F = new int[nLen / 2 + 1][nToBeClosed + 1];

        for (int i = 1; i <= nLen; i++) {
            int nLimit = Integer.min(i, nLen / 2);
            for (int j = nLimit; j >= 1; j--) {
                for (int k = array[i-1]; k <= nToBeClosed; k++) {
                    if (F[j][k] < F[j - 1][k - array[i - 1]] + array[i - 1]) {
                        F[j][k] = F[j - 1][k - array[i - 1]] + array[i - 1];
                    }
                }
            }

        }

        int a1 = F[nLen / 2][nToBeClosed], b1 = Sum - a1;
        int a2 = F[nLen / 2][nToBeClosed], b2 = Sum - a2;

        if (Math.abs(a1 - b1) < Math.abs(a2 - b2)) {
            return new int[]{a1, b1};
        } else {
            return new int[]{a2, b2};
        }

    }
}
