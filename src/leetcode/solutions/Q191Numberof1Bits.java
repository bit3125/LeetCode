package leetcode.solutions;

public class Q191Numberof1Bits {
    public int hammingWeight(int n) {
        int cnt = 0;
        while (n!=0) {
            n &= (n-1);
            cnt++;
        }
        return cnt;
    }

}
