package leetcode.codingtest.meituan.Q1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static int leastModify(int[][] matrix) {
        Set<Integer> aroundNums, diagNums;
        int cnt = 0;
        boolean modified;
        int[][] matrix2 = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix2[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < matrix.length; i+=2) {
            for (int j = 0; j < matrix[0].length; j+=2) {
                aroundNums = findAroundNums(matrix, i, j);
                if (aroundNums.contains(matrix[i][j])) { //若[i,j]与周围的相等，则改掉
                    diagNums = findDiagNums(matrix, i, j);
                    modified = false;
                    for (Integer modifyToNum :
                            diagNums) { //遍历可以修改成的集合
                        if (!aroundNums.contains(modifyToNum)) {
                            matrix[i][j] = modifyToNum;
                            modified = true;
                        }
                    }
                    if (!modified) {
                        int modifyToNum = 0;
                        while (aroundNums.contains(modifyToNum)) {
                            modifyToNum++;
                        }
                        matrix[i][j] = modifyToNum;
                        modified = true;
                    }

                    cnt++;
                }
            }
        }

        int cnt2 = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i==0 && j==0)
                    continue;

                aroundNums = findAroundNums(matrix, i, j);
                if (aroundNums.contains(matrix[i][j])) { //若[i,j]与周围的相等，则改掉
                    diagNums = findDiagNums(matrix, i, j);
                    modified = false;
                    for (Integer modifyToNum :
                            diagNums) { //遍历可以修改成的集合
                        if (!aroundNums.contains(modifyToNum)) {
                            matrix[i][j] = modifyToNum;
                            modified = true;
                        }
                    }
                    if (!modified) {
                        int modifyToNum = 0;
                        while (aroundNums.contains(modifyToNum)) {
                            modifyToNum++;
                        }
                        matrix[i][j] = modifyToNum;
                        modified = true;
                    }

                    cnt2++;
                }
            }
        }

//        return Integer.min(cnt, cnt2);
        return cnt;
    }


    public static Set<Integer> findAroundNums(int[][] matrix, int i, int j) {
        Set<Integer> results = new HashSet<>();

        int[] iSteps = {1, -1, 0, 0}, jSteps = {0, 0, 1, -1};
        int curI, curJ;
        for (int k = 0; k < 4; k++) {
            curI = i + iSteps[k];
            curJ = j + jSteps[k];
            if (outOfBound(matrix, curI, curJ))
                continue;
            results.add(matrix[curI][curJ]);

        }

        return results;
    }

    public static Set<Integer> findDiagNums(int[][] matrix, int i, int j) {
        Set<Integer> results = new HashSet<>();

        int[] iSteps = {1, -1, 1, -1}, jSteps = {1, -1, -1, 1};
        int curI, curJ;
        for (int k = 0; k < 4; k++) {
            curI = i + iSteps[k];
            curJ = j + jSteps[k];
            if (outOfBound(matrix, curI, curJ))
                continue;
            results.add(matrix[curI][curJ]);
        }

        return results;
    }


    public static boolean outOfBound(int[][] matrix, int i, int j) {
        return !(0 <= i && i < matrix.length && 0 <= j && j < matrix[0].length);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        int result = leastModify(matrix);
        System.out.println(result);

    }



}
