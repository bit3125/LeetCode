package round2.Q394DecodeString;

class Solution {
    public String decodeString(String s) {
        if (s==null || s.length()==0)
            return "";

        return decodeStringCore(s, 0, s.length());
    }

    private String decodeStringCore(String s, int start, int end) { //[,)
//        if (false) // do nothing. Boundary cases are all handled below.
//            return "";

        StringBuilder sb = new StringBuilder();
        int idx = start, startMarkIdx = start, endMarkIdx;
        int bracketCnt, num;

        while (idx<end) {
            startMarkIdx = idx;
            // find num start idx & copy chars before
            while (idx<end && !Character.isDigit(s.charAt(idx)))
                idx++;
            endMarkIdx = idx;
            sb.append(s.substring(startMarkIdx, endMarkIdx));
            if (idx==end)
                break;

            // find num end idx
            startMarkIdx = idx;
            while (Character.isDigit(s.charAt(idx)))
                idx++;
            endMarkIdx = idx;
            num = Integer.valueOf(s.substring(startMarkIdx, endMarkIdx));

            // find subRes end idx
            bracketCnt = 1;
            idx++;
            startMarkIdx = idx;
            while (bracketCnt!=0) {
                if (s.charAt(idx)=='[')
                    bracketCnt++;
                else if (s.charAt(idx)==']')
                    bracketCnt--;
                idx++;
            }
            endMarkIdx = idx - 1;
            String subRes = decodeStringCore(s, startMarkIdx, endMarkIdx);
            for (int i = 0; i < num; i++)
                sb.append(subRes);
        }

        return new String(sb);
    }
}