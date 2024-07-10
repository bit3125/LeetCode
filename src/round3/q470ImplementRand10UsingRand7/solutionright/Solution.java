package round3.q470ImplementRand10UsingRand7.solutionright;

class SolBase {
    public int rand7() {
        return 0;
    }
}


//***TODO不知道为啥一直过不了
class Solution extends SolBase {
    public int rand10() {
        int sum;
        do {
            sum = rand7() * 7 + rand7();
        } while (sum >= 40);
        return sum % 10;
    }
}