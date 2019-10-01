package others.codingtest.tencent2019.autumn.q2;

import java.util.*;

public class Main {

    static class Line {
        int x;
        int y;

        public Line(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) {

        // input
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Line[] nums = new Line[n];

        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            nums[i] = new Line(x, y);
        }

        // sort
        Arrays.sort(nums, new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return o1.y - o2.y;
            }
        });

        int max = 0, front = 0, rear = nums.length - 1;
        while (front < rear || (front == rear && 0 <= nums[front].x)) {
            if (front == rear) {
                max = Math.max(2 * nums[front].y, max);
                nums[front].x = nums[front].x - 2;
            } else {
                int a = nums[front].y, b = nums[rear].y;
                int num1 = nums[front].x;
                int num2 = nums[rear].x;
                max = Math.max(max, a + b);

                if (num1 != 1) {
                    nums[front].x--;
                } else {
                    nums[front].x--;
                    front++;
                }

                if (num2 != 1) {
                    nums[rear].x--;
                } else {
                    nums[rear].x--;
                    rear--;
                }

            }

        }

        System.out.println(max);
    }

}