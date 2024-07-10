package round3.q470ImplementRand10UsingRand7;

/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 *
 * @return a random integer in the range 1 to 7
 */

class SolBase {
    public int rand7() {
        return 0;
    }
}

//***TODO: 错了. 不均匀. 只能使用拒绝采样
class Solution extends SolBase {
    public int rand10() {
        int sum  = 10;
        for (int i = 0; i < 10; i++) {
            sum += rand7();
        }
        return sum % 10 + 1;
    }
}