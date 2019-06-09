package round1;

import java.util.Stack;

public class Q224BasicCalculator_TODO {

    public int calculate(String s) {
        if (s==null || s.length()==0)
            return -1;

        s = "(" + s + ")";
        Stack<String> stack = new Stack<>();
        String curElem;
        int curIdx = 0, endIdx;
        while (curIdx<s.length()) {
            endIdx = curElemEnd(s, curIdx);
            curElem = s.substring(curIdx, endIdx);
            curIdx = endIdx;
            stack.push(curElem);

            String peek = stack.pop();
            String n1, op, n2;
            while (  peek.equals(")") || peek.equals("+") || peek.equals("-") ) { //遇到op，则不断去驱动栈

                n2 = stack.pop();
                op = stack.pop();
                n1 = stack.pop();

                //遇到"("则驱不动
                if (op.equals("(")) { // n1"+/-" op"(" n2"n2" peek"+/-/)"
                    stack.push(n1); //"+"
                    if (peek.equals(")")) {
                        stack.push(n2);
                    } else {//peek==+/-
//                        stack.push();
                    }

                    stack.push(n2);
                } else { // "n1" "+/-" "n2"
                    if (op.equals("+")) {
                        n2 = String.valueOf(Integer.valueOf(n1) + Integer.valueOf(n2));
                    } else if (op.equals("-")) {
                        n2 = String.valueOf(Integer.valueOf(n1) - Integer.valueOf(n2));
                    }
                    stack.push(n2);
                }


                peek = stack.pop();
            }
            stack.push(peek);


            if (peek.equals(")") || peek.equals("+") || peek.equals("-")) {

                stack.pop();
                n2 = stack.pop();
                op = stack.pop();
                n1 = stack.pop();

                if (op.equals("(")) { // "+" "(" "n2"
                    stack.push(n1);
                    stack.push(n2);
                } else { // "n1" "+/-" "n2"
                    if (op.equals("+")) {
                        n2 = String.valueOf(Integer.valueOf(n1) + Integer.valueOf(n2));
                    } else if (op.equals("-")) {
                        n2 = String.valueOf(Integer.valueOf(n1) - Integer.valueOf(n2));
                    }
                    stack.push(n2);
                }

            } else if (peek.equals("+") || peek.equals("-") ) {

            }


        }

        return -1;
    }

    private int curElemEnd(String s, int curIdx) {
        if (s==null || curIdx>=s.length())
            return -1;

        if (!Character.isDigit(s.charAt(curIdx))) {//'+' '-' '(' ')'
            curIdx++;
        } else { //digit
            while (Character.isDigit(s.charAt(curIdx)))
                curIdx++;
        }
        return curIdx;//exclusive
    }

}
