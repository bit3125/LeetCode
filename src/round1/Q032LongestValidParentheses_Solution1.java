/**�㷨������ʹ��stack��������ƥ������
 * Tn=On Sn=On
 *
 * ��ջ��ѹ��ÿ�����ŵ�idx��������
 * ջ����Զ�����һ��')'��Ϊ��ǰ��Ч�ִ�����߽��ڱ����տ�ʼ��ʱ����ѹ��һ��'-1'��������ߵ�')'�߽��ڱ���
 * Ȼ���������ɨ��s������(��ѹ��ջ������)����ջ�н��г���ƥ�䡣����ƥ��ɹ�����ʱ�����ڱ��ڣ����ǿգ�����㵱ǰ��Ч�ִ�����
 * ������max������ƥ��ʧ�ܣ�pop���ڱ���ջ�գ�����ѹ����������)�����µ��ڱ���
 *
 * '('��Զ��ѹ��ջ����һֱ�ȴ�������')'����ƥ�䣬�����ӵ�ǰ��Ч�ִ��ĳ��ȣ��������ϵ�ǰ��Ч�Ӵ�
 * ')'�����������
 * 1.ջ����'('����ƥ��
 * 2.ջ����'('����ƥ�䣬�Ǿ���ζ�ŵ�ǰ')'����˵�ǰ��Ч�Ӵ���Ҳ��Ψһ��ϵ�ǰ��Ч�ִ��ķ�ʽ��
 * ��ʱ��')'����Ϊ�±߽���ջ����Ϊ֮��Ĵ����޿�����֮ǰ�Ĵ�������Ч�ִ���
 * */

package round1;

import java.util.Stack;

public class Q032LongestValidParentheses_Solution1 {

    public int longestValidParentheses(String s) {
        if (s==null || s.length()==0)
            return 0;

        int maxLen = 0, curLen;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else { //==')'
                stack.pop();//�����pop����pop�����ֶ�����1.��)ƥ���(��ջ�ǿգ�2.��(��ƥ�䣬���ڱ�pop����ջ��
                if (stack.isEmpty()) { //ƥ��ʧ�ܣ���Ч�Ӵ������
                    stack.push(i); //push�����ڱ����߽�
                } else { //ƥ��ɹ�������һ�ε�ǰ��Ч�ִ�����
                    maxLen = Integer.max(maxLen, i - stack.peek()); //���㵱ǰ��Ч�ִ����Ȳ�����maxLen
                        //***bug:��ʱpeekΪ��ǰ��Ч�Ӵ�����߽磬Ӧ����peek������pop����
                }
            }
        }
        //��ǰ��ÿ��ƥ��)֮�󶼼���һ�ε�ǰ���ȣ��������ʣ�ദ����

//        //ʣ�ദ��, ���ջһ���ǿգ�ʣ�����ɵ�'('���ڱ�')'��������Щ����δ����һ������Ч�ִ�����ǰ�����ˣ�
//        // ��ÿ������֮�䶼��һ����������Ч�ִ�����Ҫ���ν��д���
//        int front = stack.pop(), rear;
//        maxLen = Integer.max(maxLen, s.length()-front-1);
//        rear = front;
//        while (!stack.isEmpty()) {
//            front = stack.pop();
//            maxLen = Integer.max(maxLen, rear-front-1);
//            rear = front;
//        }
        /**����������Լ�WA�㷨�����ͬ��WA�㷨����ʹ�ü򵥵�cnt����������ջ����Ϣ��̫�٣��ڽ���ʣ�ദ���ʱ���޷�
        * ��֪����ڽ��еĽ������Ӵ�����Ч�����Ƕ��١����˷��Ͳ�һ���� ������ʹ����һ����stack������Ϣ�洢����idx��Ϊ
        * element push��stack�У�����ʱ�ش��������Ч�ִ������±߽磬ʹ��ʣ�ദ�����п���
         *
         * ����ϸһ�룬���ְ�idx push��stack��Ȼ������ֱ��pop��������dist��ʱ��ʹ��i-stack.peek()�ķ�����
         * �������Q084��״ͼ�������stack�ⷨ��һ����˼�룿
        */
        return maxLen;
    }

    public static void main(String[] args) {
        Q032LongestValidParentheses_Solution1 q = new Q032LongestValidParentheses_Solution1();
        String str = ")(((((()())()()))()(()))(";
        q.longestValidParentheses(str);
    }

}
