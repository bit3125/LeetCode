package others.codingtest.netease.q3.q1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        ArrayList<BigInteger> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Stack<Integer> stack = new Stack<>();
            int tmp =arr[i];
            while (tmp>9){
                tmp-=9;
                stack.push(9);
            }
            if(tmp != 0){
                stack.push(tmp);
            }
            BigInteger r = new BigInteger(String.valueOf(0));
            while (!stack.isEmpty()){
                Integer pop = stack.pop();
                r = r.multiply(BigInteger.valueOf(10)).add(new BigInteger(String.valueOf(pop)));
            }
            res.add(r);
        }
        for (BigInteger i:res){
            System.out.println(i);
        }
    }
}