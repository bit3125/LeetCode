package round1;

public class Q165CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        if (version1==null ||version2==null)
            return 0;

        String[] v1s = version1.split("\\."), v2s = version2.split("\\.");
        int v1Num, v2Num;
        for (int i = 0, j = 0; i < v1s.length||j<v2s.length; i++, j++) {
            v1Num = i < v1s.length ? Integer.valueOf(v1s[i]) : 0;
            v2Num = j < v2s.length ? Integer.valueOf(v2s[j]) : 0;

            if (v1Num<v2Num)
                return -1;
            else if (v1Num>v2Num)
                return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Q165CompareVersionNumbers q = new Q165CompareVersionNumbers();
//        String s1 = "0.1", s2 = "1.1";
//        String s1 = "1.0.1", s2 = "1";
//        String s1 = "7.5.2.4", s2 = "7.5.3";
//        String s1 = "1.01", s2 = "1.001";
        String s1 = "1.0", s2 = "1.0.0";
        System.out.println(q.compareVersion(s1, s2));
    }

}
