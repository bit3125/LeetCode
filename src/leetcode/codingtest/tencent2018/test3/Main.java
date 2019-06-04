package leetcode.codingtest.tencent2018.test3;

import java.util.Scanner;

//TODO
public class Main {

    public static int firstDayEat(int n, int m) {
        return (int) ( m/(Math.pow(2,n)-1)*Math.pow(2, n-1));
    }

//    public static binarySearch() {
//
//    }

    public static void main(String[] args) {
        //input
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();

        int output = firstDayEat(n, m);
        System.out.println(output);
    }
}
