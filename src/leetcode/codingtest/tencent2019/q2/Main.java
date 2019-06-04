package leetcode.codingtest.tencent2019.q2;

import java.util.Scanner;

public class Main {

    public static int minCost(int[] powers, int[] costs) {
        int sumPowers = 0, sumCosts = 0;
        for (int i = 0; i < powers.length; i++) {
            if (powers[i] > sumPowers) {
                sumCosts += costs[i];
                sumPowers += powers[i];
            }
        }

        return sumCosts;
    }

    public static void main(String[] args) {
        //input
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] powers = new int[n];
        int[] costs = new int[n];
        for (int i = 0; i < n; i++)
            powers[i] = in.nextInt();
        for (int i = 0; i < n; i++)
            costs[i] = in.nextInt();

        //output
        int output = minCost(powers, costs);
        System.out.println(output);
    }
}
