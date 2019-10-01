package others.codingtest.netease.q2;

import java.util.Scanner;

public class Main {

    private static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        n = Integer.parseInt(in.nextLine());

        String[] nums = new String[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextLine();
        }

        long r;
        for (int i = 0; i < n; i++) {
            ans = Integer.MAX_VALUE;
            String[] strs = nums[i].split(" ");
            r = Long.parseLong(strs[0]);
            long s = Long.parseLong(strs[1]), u = Long.parseLong(strs[2]), v = Long.parseLong(strs[3]);

            func(r, s, u, v, 0);

            System.out.println(ans);
        }

    }

    public static void func(long a, long b, long p, long q, int ff) {
        if (!(b > a)) {
            ans = Math.min(ans, ff);
            return;
        } else if (b <= p + a) {
            ff++;
            ans = Math.min(ans, ff);
            return;
        }

        func(a + p, b, p, q, ff + 1);
        func(a, b, p*q, q, ff + 1);

    }

}
