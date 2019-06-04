package leetcode.codingtest.tencent2018.test2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int drawScoreDiff(int n, int[] cards) {
        Arrays.sort(cards);
        int scoreDiff = 0, curDif = 0;
        for (int i = 0; i+1<cards.length ; i+=2) {
            curDif = cards[i] - cards[i + 1];
            scoreDiff += ( (cards.length&1)==0 )?-curDif:curDif;
        }
        if ((cards.length & 1) == 1)
            scoreDiff += cards[cards.length - 1];

        return scoreDiff;
    }

    public static void main(String[] args) {
        //input
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] cards = new int[n];
        for (int i = 0; i < n; i++)
            cards[i] = in.nextInt();
        if (n<=0){
            System.out.println(0);
            return;
        }

        //cal
        int scoreDiff = drawScoreDiff(n, cards);
        System.out.println(scoreDiff);
    }

}
