package others.codingtest.netease.q3.q2;

import java.util.Scanner;

public class Main {

    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        n = Integer.parseInt(scanner.nextLine());

        String[] nums = new String[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextLine();
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

    public static void func(long a, long b, long p, long q, int cnt) {
        if (!(b > a)) {
            ans = Math.min(ans, cnt);
            return;
        } else if (b <= a + p) {
            cnt += 1;
            ans = Math.min(ans, cnt);
            return;

        }
        func(a + p, b, p, q, cnt + 1);
        func(a, b, p * q, q, cnt + 1);
    }
}