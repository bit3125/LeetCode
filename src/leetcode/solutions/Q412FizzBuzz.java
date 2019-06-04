package leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

public class Q412FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> results = new ArrayList<>();
        if (n<1)
            return results;

        StringBuilder sb;
        for (int i = 1; i <= n; i++) {
            if (i%3!=0 && i%5!=0){
                results.add(String.valueOf(i));
                continue;
            }
            //else
            sb = new StringBuilder();
            if (i%3==0)
                sb.append("Fizz");
            if (i%5==0)
                sb.append("Buzz");
            results.add(new String(sb));
        }

        return results;
    }

}
