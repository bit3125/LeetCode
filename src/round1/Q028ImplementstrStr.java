package round1;

/**�㷨������Tn = On^2, Sn = O1
 *
 * ����ı���Ϊ��ģʽ��ƥ�����⣬���Ž�Ӧ��ʹ��KMP�����
 * ���ǱϾ���Easy��������û��Ҫ����ô���ӣ�ֱ�ӱ�����
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
