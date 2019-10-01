package others.codingtest.netease.q1;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }

//        List<BigInteger> results = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println(func(array[i]));
        }

    }

    public static BigInteger func(int a) {
        Stack<Integer> stack = new Stack<>();
        int p = a;
        while (!(p <= 9)) {
            p -= 9;
            stack.push(9);
        }

        if (p != 0) {
            stack.push(p);
        }

        BigInteger r = new BigInteger(String.valueOf(0));
        while (!stack.isEmpty()) {
            Integer peek = stack.pop();
            BigInteger bi1 = BigInteger.valueOf(10);
            BigInteger bi2 = new BigInteger(String.valueOf(peek));
            r = r.multiply(bi1).add(bi2);
        }
        return r;
    }

}
