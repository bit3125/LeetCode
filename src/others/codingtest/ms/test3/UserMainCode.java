package others.codingtest.ms.test3;

import java.util.LinkedList;
import java.util.List;

public class UserMainCode {

    public int findPosition(int input1, int input2, int[][] input3) {
        int n = input1, nOfQues = input2;
        int[][] ques = input3;

        //init
        int sum = 0;
        List<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        //Event
        for (int i = 0; i < nOfQues; i++) {
            int e = ques[i][0];
            int x = ques[i][1];

            if (e == 1) {
                q.remove(0);
            } else if (e == 2){
                q.remove(new Integer(x));
            } else if (e == 3) {
                sum += q.indexOf(new Integer(x))+1;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int n = 5, nOfQues = 3;
        int[][] ques = new int[][]{{1, 0}, {3, 3}, {2, 2}};
        UserMainCode u = new UserMainCode();

        System.out.println(u.findPosition(n, nOfQues, ques));
    }


}
