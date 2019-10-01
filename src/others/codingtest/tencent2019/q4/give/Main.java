package others.codingtest.tencent2019.q4.give;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = in.nextInt();

        List<Integer> res = func(array, k);

        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    public static List<Integer> func(int[] array, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int curRes;
            int minVal = Integer.MAX_VALUE;
            boolean flag = false;
            for (int p = 0; p < array.length; p++) {
                if (array[p] > 0) {
                    minVal = Integer.min(minVal, array[p]);
                    flag = true;
                }
            }

            if (!flag) {
                curRes = 0;
            } else {
                int diff;
                for (int j = 0; j < array.length; j++) {
                    if (array[j] > 0) {
                        diff = array[j] - minVal;
                        array[j] = Integer.max(diff, 0);
                    }
                }
                curRes = minVal;
            }

            list.add(curRes);
        }

        return list;
    }

}
