package leetcode.solutions;

/**本质为进制转换的变种（没有0）
 * */
public class Q171ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        if(s==null || s.length()==0)
            return 0;

        int idx = 0;
        int sum = 0;
        while (idx < s.length()) {
            sum *= 26;
            sum += s.charAt(idx) - 'A' + 1;
            idx++;
        }
        return sum;
    }

    public static void main(String[] args) {
        Q171ExcelSheetColumnNumber q = new Q171ExcelSheetColumnNumber();
        String s = "ZY";

        System.out.println(q.titleToNumber(s));;
    }

}
