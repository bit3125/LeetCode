package others.codingtest.netease.q3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int n;

        while (t > 0) {
            n = in.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
            }

            System.out.println(func(array));

            t--;
        }
    }

    public static int func(int[] array) {
        int[] sums = new int[array.length];
        int maxLen = Integer.MIN_VALUE;

        sums[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            sums[i] = sums[i - 1] + array[i];
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < sums[j - 1]) {
                    maxLen = Integer.max(maxLen, j - i);
                    break;
                }
            }

            for (int j = i; j < sums.length; j++) {
                sums[j] -= array[i];
            }
        }

        return maxLen;
    }



}
