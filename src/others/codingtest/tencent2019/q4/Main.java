package others.codingtest.tencent2019.q4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < nums.length;i++)
            nums[i] = in.nextInt();

        Arrays.sort(nums);
        List<Integer> res = func(k, nums);

         for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    public static List<Integer> func(int p, int[] nums) {
        List<Integer> result = new ArrayList<>();
        int idx = 0, s = 0;
        while (p > 0){
            if (idx == nums.length)
                result.add(0);
            else{
                while (idx + 1 < nums.length && nums[idx + 1] == nums[idx]) {
                    idx++;
                }

                nums[idx] = nums[idx] - s;
                result.add(nums[idx]);
                s = s + nums[idx];
                idx++;
            }

            p--;
        }

        return result;
    }
}