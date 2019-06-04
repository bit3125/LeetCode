package leetcode.solutions;

public class Q032LongestValidParentheses_WA {

    public int longestValidParentheses(String s) {
        if (s==null || s.length()==0)
            return 0;

        //init
        s = s + "("; // an important trick!相当于用来最后压栈，处理最后栈中残留元素的
        int leftStack = 0, curLen = 0, maxLen = 0;
        int idx = 0;
        while (idx < s.length() && s.charAt(idx)!='(')
            idx++;

        //cal
        while (idx < s.length()) {
            if (s.charAt(idx) == '(') {

                leftStack++;
            }else{ //==')'
                if (leftStack==0){
                    if (curLen>maxLen)
                        maxLen = curLen;

                    leftStack = 0;
                    curLen = 0;
                }
                //else: correct match
                leftStack--;
                curLen += 2;
            }

            idx++;
        }
        return maxLen;
    }

}
