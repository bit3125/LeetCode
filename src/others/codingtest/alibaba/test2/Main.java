package others.codingtest.alibaba.test2;

import java.util.Comparator;
import java.util.PriorityQueue;

import javafx.util.Pair;

class Main {
    static String calculate(int m, int k) {
        int yearStart = 2019;
        int[] number = calNumber(m);

        int[] zhus = new int[7];
        int cnt = 2, tmp;
        zhus[0] = 1;
        zhus[6] = 1;
        while (cnt<m){
            yearStart++;
            tmp = zhus[6];
            cnt += tmp;
            zhus[6] += zhus[5];
            for(int i=5;i>0;i--){
                zhus[i] = zhus[i - 1];
                cnt+=zhus[i-1];
            }
            zhus[0]=tmp;
        }

        PriorityQueue<Pair<Integer,Integer>> q = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.getKey()-o2.getKey();
            }
        });

        for(int i=1;i<=m;i++) {
            int co = number[i];
            int reverse = 0;
            while (co!=0) {
                reverse = reverse*10+co%10;
                co/=10;
            }
            q.offer(new Pair<>(reverse,i));
            if(i>k)
                q.poll();
        }
        return number[m]+ "," + yearStart + "," + q.poll().getValue();
    }

    static int[] calNumber(int m) {
        int[] number = new int[m+1];
        number[1] = 2;
        number[2] = 3;
        number[3] = 4;
        for(int i=4;i<=m;i++)
            number[i] = number[i-3] + number[i-2];
        return number;
    }

    public static void main(String[] args) {
        System.out.println(calculate(20,3));
    }

}
