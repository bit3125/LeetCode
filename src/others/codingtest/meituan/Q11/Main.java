package others.codingtest.meituan.Q11;
import java.util.*;

public class Main{

    public static int leastModify(int[][] matrix, int n, int m) {
        Map<Integer,Integer> map2 = new HashMap<>(), map1 = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int num = matrix[i][j];
                if(((i+j)%2) == 0)
                    map1.put(num,map1.getOrDefault(num,0)+1);
                else
                    map2.put(num,map2.getOrDefault(num,0)+1);
            }
        }

        int cnt = 0;
        int oufst = 0, ouscd = 0, ouNum=0, jifst = 0, jiscd = 0,jiNum=0;
        for(Map.Entry<Integer,Integer> entry: map1.entrySet()){
            if(entry.getValue()>oufst){
                ouscd = oufst;
                oufst = entry.getValue();
                ouNum = entry.getKey();
            }else if(entry.getValue()>ouscd){
                ouscd = entry.getValue();
            }
        }
        for(Map.Entry<Integer,Integer> entry: map2.entrySet()){
            if(entry.getValue()>jifst){
                jiscd = jifst;
                jifst = entry.getValue();
                jiNum = entry.getKey();
            }
            else if(entry.getValue()>jiscd){
                jiscd = entry.getValue();
            }
        }

        cnt = getCnt(n, m, oufst, ouscd, ouNum, jifst, jiscd, jiNum);
        return cnt;
    }

    private static int getCnt(int n, int m, int oufst, int ouscd, int ouNum, int jifst, int jiscd, int jiNum) {
        int cnt;
        if(jiNum!=ouNum){
            cnt = m*n-jifst-oufst;
        }
        else if(jifst>oufst){
            cnt = m*n-jifst-ouscd;
        }
        else
            cnt = m*n-oufst-jiscd;
        return cnt;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        System.out.println(leastModify(matrix, n, m));
    }

}

