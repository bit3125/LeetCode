package round2.Q344ReverseString;

class Solution {
    public void reverseString(char[] s) {
        if (s==null)
            return;

        char tmp ;
        int front = 0, rear = s.length-1;
        while (front < rear) {
            tmp = s[front];
            s[front] = s[rear];
            s[rear] = tmp;

            front++;
            rear--;
        }
    }
}