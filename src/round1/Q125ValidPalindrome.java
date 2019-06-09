package round1;

public class Q125ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s==null || s.length()==0)
            return true;

        int front = 0, rear = s.length()-1;
        while (front < rear) {
            while (front<rear && !(Character.isLetter(s.charAt(front)) || Character.isDigit(s.charAt(front))))
                front++;
            while (front<rear && !(Character.isLetter(s.charAt(rear)) || Character.isDigit(s.charAt(rear))))
                rear--;
            if (!(front<rear))
                break;
            if (!equalsIgnoreCases(s.charAt(front), s.charAt(rear)))
                return false;

            front++;
            rear--;
        }

        return true;
    }

    private boolean equalsIgnoreCases(char a, char b){
        return a == ( Character.isDigit(a)?b:( Character.isLowerCase(a)?Character.toLowerCase(b):Character.toUpperCase(b) ) ) ;
    }

    public static void main(String[] args) {
        String str = "race a car";
        Q125ValidPalindrome q = new Q125ValidPalindrome();
        System.out.println(q.isPalindrome(str));;
    }
}
