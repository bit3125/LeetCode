package others.codingtest.netease.q3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int n;
        while (t > 0) {
            // input
            n = in.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
            }

            // output
            System.out.println(func(array));

            t--;
        }
    }

//    public static void main(String[] args) {
//        int[] array = new int[]{1, 3, 9, 2, 6};
//        System.out.println(func(array));
//    }

    public static int func(int[] array) {

        int[] sums = new int[array.length]; // �洢ǰiλ��
        int maxLen = Integer.MIN_VALUE;
        // cal sum
        sums[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            sums[i] = sums[i - 1] + array[i];
        }


        // ������i��ͷ������������еĳ���
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < sums[j - 1]) {
                    maxLen = Integer.max(maxLen, j - i);
                    break;
                }
            }


            // ���¼���sums
            for (int j = i; j < sums.length; j++) {
                sums[j] -= array[i];
            }
        }

        return maxLen;
    }
}
