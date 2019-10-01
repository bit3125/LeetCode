package others.codingtest.tencent2019.autumn.q1;

import java.util.Scanner;

public class Main0 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];

        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            strings[i] = in.next();
        }

        for (int i = 0; i < n; i++) {
            boolean print = func(nums[i], strings[i]);
            System.out.println(print?"YES":"NO");
        }
    }

    public static boolean func(int num, String s) {
        boolean flag = false;
        if (num < 11)
            return false;

        while (s.length() >= 11) {
            if ('8' == s.charAt(0)) {
                return true;
            } else {
                s = s.substring(1);
            }
        }
        return flag;
    }
}