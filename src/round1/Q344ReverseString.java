package round1;

public class Q344ReverseString {
    public void reverseString(char[] s) {
        if (s==null || s.length==0)
            return;

        int front = 0, rear = s.length-1;
        char tmp;
        while (front < rear) {
            tmp = s[front];
            s[front] = s[rear];
            s[rear] = tmp;

            front++;
            rear--;
        }
    }

}
