package others.codingtest.Airbnb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        //input
//        Scanner in = new Scanner(System.in);
//        String input;
//        while (in.hasNextLine()) {
//            input = in.nextLine();
//            System.out.println( parse(input) );
//        }


        //output


        String testStr = "\"John \"\"Mo\"\"\",Smith,sfn@flkaei.km,biking and hiking,,\"Seattle, WA\",23";
        System.out.println(parse(testStr));

    }

    public static String parse(String s){
        String[] tmpList = s.split(",");
        List<String> strList = new ArrayList<>();
        String prev, cur;

        //merge "" which are splited
        int idx = 1;
        while (idx < tmpList.length) {
            prev = tmpList[idx-1];
            cur = tmpList[idx];
            if (prev.equals("")){
                strList.add(prev);
                idx++;
                continue;
            }

            if (prev.charAt(0) == '\"' && cur.charAt(cur.length() - 1) == '\"') {
                System.out.println(prev.substring(1, prev.length()));
                strList.add( prev.substring(1, prev.length()) + cur.substring(0, cur.length() - 1));
                idx += 2;
            } else {
                strList.add(prev);
                idx++;
            }
        }
        prev = tmpList[tmpList.length-1];
        strList.add(tmpList[tmpList.length-1]);

        for (int i = 0; i < strList.size(); i++) {
            cur = strList.get(i);
            if (strList.get(i).equals(""))
                continue;
            if (cur.charAt(0) == '\"' && cur.charAt(cur.length() - 1) == '\"') {

            }
        }

        //create result
        //first_name,last_name,email,interests,notes,city,age

        String result ;
        result = strList.get(0) + ", " + strList.get(6) + " years old, is from " +
                strList.get(5) + " and is interested in " + strList.get(3) + "." ;
        return result;
    }

}