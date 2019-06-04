package leetcode.solutions;

public class Q038CountandSay {
    public String countAndSay(int n) {
        if (n<1 || n>30)
            return "";

        String str = "1";
        for (int i = 0; i < n-1; i++)
            str = next(str);

        return str;
    }

    private String next(String str){
        StringBuilder next = new StringBuilder();
        char c = str.charAt(0);
        int cnt = 0, idx = 0;
        while (true) {
            while (idx<str.length() && str.charAt(idx)==c) {
                cnt++;
                idx++;
            }
            next.append( (char)(cnt+'0') );
            next.append(c);

            if (!(idx<str.length())) break;
            cnt = 0;
            c = str.charAt(idx);
        }
        return new String(next);
    }

}
