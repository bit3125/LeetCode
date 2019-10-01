package others.codingtest.tencent2019.autumn.q5;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] arr1 = new int[n], arr2 = new int[n];

        for (int i = 0; i < n; i++)
            arr1[i] = in.nextInt();
        for (int i = 0; i < n; i++)
            arr2[i] = in.nextInt();

        HashMap<Integer, Integer> tool = new HashMap<>();

        int num, cnt;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                num = arr2[j] + arr1[i];
                cnt = tool.getOrDefault(num, 0);
                tool.put(num, cnt + 1);
            }
        }

        int ans = 0;
        for (int key : tool.keySet()) {
            if (tool.get(key) % 2 != 0)
                ans ^= key;
        }

        System.out.println(ans);
    }
}
