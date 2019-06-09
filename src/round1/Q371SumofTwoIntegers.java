
package round1;

public class Q371SumofTwoIntegers {

    public int getSum(int a, int b) {
        int xor; //tmp for a^b
        while (b!=0) {
            xor = a^b;
            b = (a&b)<<1; //store carry value
            a = xor; //store xor value
        }
        return a;
    }

}
