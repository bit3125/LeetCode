/**�㷨����������Q032��ջ���� ����δAC��
 * ���ڴ��п��ܳ�����ĸ�����Եȼ۵����Ϊ��ÿ����ͬ�����Ŷ���Ϊ���в���
 * �����Ǽ��������ÿ�����ź��涼���Ų�ͬ���ַ���
 *
 * ���������ջ�е�')'�߽�Ϊ�磬���ܴ���Ϊ�������Σ����ֻ���ܰ�������Ч')'���Ҷ�ֻ���ܰ�������Ч'('��
 * �ֱ��ۼƳ���Ч�������ŵ�����Ϊm,n ��Ȼ����������ѡ��m��)�����޳����Ҷ�����ѡ��n��'('�����޳�
 * �������ϳ������ַ����ӽ����set�м��ɡ�
 *
 * ��ʵ����㷨�����⣬��Ӧ����ͳ��redunt�������ŵļ���������Ϊ����˵�Ƴ���λ����Ҷ���ͷ�����Ŷ���һ���ģ����в���
 * ���е�make sense�е� ���ܡ�������˵��������Գ����������ŵĵط�������ǰ��������ͬ�ַ����е�ÿ�����ű��Ƴ��ǵ�Ч��
 * ����"()())"�У����һ��)�뵹����)���Ƴ��ǵ�Ч�ģ����ǲ����Ƴ���һ��)
 *
 * */

package round1;

import java.util.*;

public class Q301RemoveInvalidParentheses_Solution1_WA {

    public List<String> removeInvalidParentheses(String s) {
        List<String> results;
        if (s==null){
            results  = new ArrayList<>();
            return results;
        } else if (s.length() == 0) {
            results  = new ArrayList<>();
            results.add("");
            return results;
        }

        int redundLeft = 0, redundRight = 0;
        int boundIdx =0;

        //find boundIdx and cnt redundLeft & redundRight
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') { //***bug:s�л������������ַ�
                stack.pop();//�����pop����pop�����ֶ�����1.��)ƥ���(��ջ�ǿգ�2.��(��ƥ�䣬���ڱ�pop����ջ��
                if (stack.isEmpty()) { //ƥ��ʧ�ܣ���Ч�Ӵ������
                    stack.push(i); //push�����ڱ����߽�
                    redundRight++;
                } else { //ƥ��ɹ�
                    //do nothing here
                }
            }//else: do nothing
        }
        while (stack.size()>=2) {
            stack.pop();
            redundLeft++;
        }
        boundIdx = stack.pop();

        //combination
            //init
        Set<String> set = new HashSet<>();
        boolean[] selected = new boolean[s.length()];
        Arrays.fill(selected, true);
            //body
        combination(set, selected, s, 0, boundIdx, redundLeft, redundRight);
        results = new ArrayList<String>(set);
        return results;
    }

    /**
     * Params:
     * selected:���ÿλ����Ƿ�ѡ������
     * boundIdx:��������һ�����������ŵ��±�
     * remainLeft:�Ҷ���ʣ�µĿ�ѡ����������
     * remainRight:�����ʣ�µĿ�ѡ����������
     * redundLeft:�Ҷ�����Ҫѡ���Ķ�����������
     * redundRight:�������Ҫѡ���Ķ�����������
     * */
    public void combination(Set<String> set, boolean[] selected, String s, int curIdx,
                            int boundIdx, int redundLeft, int redundRight){

        if (redundLeft<0 || redundRight<0) //����ʣ��,��֦
            return;
        else if (curIdx == s.length()) {//TODO ͳһ����
            if ( !(redundLeft==0 && redundRight==0))
                return;
            //else : create string
            char[] res = new char[s.length()];
            int len = 0, idx = 0;
            while (idx < s.length()) {
                if (selected[idx]) {
                    res[len] = s.charAt(idx);
                    len++;
                }
                idx++;
            }
            set.add(new String(res, 0, len));
            return;
        }
        //else: curIdx < s.length() && redundLeft>=0 && redundRight>=0

        if (curIdx <= boundIdx) { //��Ȼ�����
            while (s.charAt(curIdx) != ')') {//s.charAt(boundIdx)һ��Ϊ')'���ʲ�����Խ�磬����Խ���ж�
                selected[curIdx] = true; //***bug:��һ�����ݵ�����
                curIdx++;
            }

            selected[curIdx] = false;
            combination(set, selected, s, curIdx + 1, boundIdx, redundLeft, redundRight-1);
            selected[curIdx] = true;
            combination(set, selected, s, curIdx + 1, boundIdx, redundLeft, redundRight);
        } else { //�ѵ��Ҷ�
            while (curIdx < s.length() && s.charAt(curIdx) != '(') { //�����Խ���ж�
                selected[curIdx] = true; //***bug:��һ�����ݵ�����
                curIdx++;
            }
            if (curIdx == s.length()) { //ֱ�ӵ�������
                combination(set, selected, s, curIdx, boundIdx, redundLeft, redundRight);
                return ; //***bug:��дreturn
            }

            selected[curIdx] = false;
            combination(set, selected, s, curIdx + 1, boundIdx, redundLeft-1, redundRight);
            selected[curIdx] = true;
            combination(set, selected, s, curIdx + 1, boundIdx,redundLeft, redundRight);
        }
    }

    public String constructString(String s, boolean[] selected){
        char[] chars = new char[s.length()];
        int len = 0;
        for (int i = 0; i < selected.length; i++) {
            if (selected[i]) {
                chars[len++] = s.charAt(i);
            }
        }

        return new String(chars, 0,len);
    }

    public static void main(String[] args) {
        Q301RemoveInvalidParentheses_Solution1_WA q = new Q301RemoveInvalidParentheses_Solution1_WA();
        String s = "(a)())()";

        q.removeInvalidParentheses(s);

    }

}
