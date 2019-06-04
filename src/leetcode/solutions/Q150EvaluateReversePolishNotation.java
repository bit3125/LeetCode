package leetcode.solutions;

import java.util.Stack;

public class Q150EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        if (tokens==null || tokens.length==0)
            return -1;

        Stack<Integer> stack = new Stack<>();
        Integer n1, n2, res=null;
        String token;
        for (int i = 0; i < tokens.length; i++) {
            token = tokens[i];
            if (token.length() == 1 && !Character.isDigit(token.charAt(0))) { //token is operator
                n1 = stack.pop();
                n2 = stack.pop();
                if (token.equals("+")) {
                    res = n2+n1;
                } else if (token.equals("*")) {
                    res = n2*n1;
                } else if (token.equals("-")) {
                    res = n2-n1;
                } else{// if (tokens.equals("/")) {
                    res = n2/n1;
                }
                stack.push(res);
            } else { //token is a Integer
                stack.push(parseInt(token));
            }
        }
        return stack.pop();
    }

    /**将传入的表示int的string转化为int
     * s的格式可以为 {1，+1，-1}
     * */
    private int parseInt(String s) {
        if (s==null ||s.length()==0)
            return Integer.MIN_VALUE;

        int curIdx = 0;
        boolean positive = true;
        if (s.charAt(curIdx)=='+'){
            positive = true;
            curIdx++;
        } else if (s.charAt(curIdx) == '-') {
            positive = false;
            curIdx++;
        }

        int ret = 0;
        while (curIdx < s.length()) {
            ret *= 10;
            ret += s.charAt(curIdx) - '0'; //***bug: ret = s.char....
            curIdx++; //***bug:forget
        }
        return positive?ret:-ret;//***bug:forget positive
    }

    public static void main(String[] args) {
        Q150EvaluateReversePolishNotation q = new Q150EvaluateReversePolishNotation();
        String[] tokens = new String[]{"2","1","+","3","*"};
        q.evalRPN(tokens);
    }

}
