package others.codingtest.tencent2019.spring.q1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Character> clipString(String str) {
        List<Character> charList = new ArrayList<>();
        boolean mark = false;
        for(int i = 0;i < str.length();i++)
            charList.add(str.charAt(i));


        while(charList.size() > 0){
            mark = false;
            for(int i = 1;i < charList.size();i++){
                if(charList.get(i) != charList.get(i-1)){
                    charList.remove(i);
                    charList.remove(i-1);
                    mark = true;
                    i--;
                }
            }

            if(!mark || charList.size()==1)
                break;
        }

        return charList;
    }

    public static void main(String[] args){
        //input
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str;

        if(n <= 0){
            System.out.println(0);
            return;
        }
        in.nextLine();
        str = in.nextLine();

        System.out.println(clipString(str).size());
    }
}
