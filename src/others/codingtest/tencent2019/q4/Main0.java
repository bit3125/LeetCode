package others.codingtest.tencent2019.q4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main0 {

    public static void main(String[] args) {
        // input

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = in.nextInt();

        // cal
        List<Integer> res = getRes(array, k);

        // output
        for (int a : res) {
            System.out.println(a);
        }
    }

    public static List<Integer> getRes(int[] array, int k) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++)
            result.add(findMinPositive(array));

        return result;
    }

    public static int findMinPositive(int[] array) {
        int min = Integer.MAX_VALUE;
        boolean found = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                min = Integer.min(min, array[i]);
                found = true;
            }
        }

        if (!found) {
            return 0;
        } else {
            int diff;
            for (int i = 0; i < array.length; i++) {
                if (array[i] > 0) {
                    diff = array[i] - min;
                    array[i] = Integer.max(diff, 0);
                }
            }
            return min;
        }
    }
}
