package round1;

/**算法分析：Tn = On^2, Sn = O1
 *
 * 此题的本质为单模式串匹配问题，最优解应该使用KMP解决，
 * 但是毕竟是Easy。。。。没必要搞这么复杂，直接暴力了
 *
 * */
public class Q028ImplementstrStr {

    public int strStr(String haystack, String needle) {
        if (haystack==null /* || (haystack.equals("")&&(!needle.equals("")))  */)
            return -1;

        for (int i = 0; i <= haystack.length()-needle.length(); i++) {
            if ( needle.equals( haystack.substring( i, i+needle.length() ) ) )
                return i;
        }
        return -1;
    }
}
