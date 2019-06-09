package others.codingtest;

public class Solution1{

    int edit(int a, int b) {
        int cnt = 0;
        if (a>=b)
            return a-b;

        while (a != b) {
            if ( (b&1)==0 ) {
                b++;
            } else {
                b >>>= 1;
            }
            cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) {
//        int a = 5, b = 8;
//        Solution q = new Solution();
//        System.out.println(q.edit(a, b));
//        System.out.println("".split(",").length);


        int a = 100, b = 50, c = a---b, d = a---b;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }


}
