//package round4.q151ReverseWordsinaString;
//
//class Solution {
//    public String reverseWords(String s) {
//        if (s == null || s.length() == 0) {
//            return s;
//        }
//
//        char[] chars = s.trim().toCharArray();
//        reverseCharArray(chars, 0, chars.length-1);
//
//        int start = 0, end = 0;
//        while(end < chars.length) {
//            if (chars[end] == ' ') {
//                reverseCharArray(chars, start, end - 1);
//                while(end < chars.length && chars[end] == ' ') {
//                    end++;
//                }
//                start = end;
//            } else {
//                end++;
//            }
//        }
//        return new String(chars);
//    }
//
//    private void trimCharArray(char[] chars) {
//        if (chars == null || chars.length == 0) {
//            return chars
//        }
//    }
//    private void reverseCharArray(char[] chars, int front, int rear) {
//        if (chars == null || front >= chars.length || rear >= chars.length || front >= rear) {
//            return;
//        }
//
//        int mid = (front + rear) / 2 ;
//        char tmp;
//        for (int i = front; i <= mid; i++) {
//            tmp = chars[i];
//            chars[i] = chars[front + rear - i];
//            chars[front + rear - i] = tmp;
//        }
//    }
//
//    public static void main(String[] args) {
//        String s = "the sky is blue";
//        Solution sl = new Solution();
//        System.out.println(sl.reverseWords(s));
//    }
//}