    package others.codingtest.netease.q4;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;

    public class Main {

        public static int ans ;
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            func1(arr);
            System.out.println(ans);
        }

        public static List<Integer> func1(int[] nums) {
            if (nums==null || nums.length==0)
                return new ArrayList<>();

            int[] cnts = new int[nums.length];
            int[] copyData = new int[nums.length], copyCnts = new int[nums.length];
            mergeSort(nums, copyData, cnts, copyCnts, 0, nums.length);

            return null;
        }

        public  static void mergeSort(int[] nums, int[] copyData, int[] cnts, int[] copyCnts, int start, int end) {
            if (end - start <= 1) {
                return;
            }

            int mid = (start + end) / 2;
            mergeSort(nums, copyData, cnts, copyCnts, start, mid);
            mergeSort(nums, copyData, cnts, copyCnts, mid, end);
            merge(nums, copyData, cnts, copyCnts, start, mid, mid, end);

        }

        public static  void merge(int[] nums, int[] copyData, int[] cnts, int[] copyCnts, int s1, int e1, int s2, int e2) {
            if (s1 >= e1 || s2 >= e2) {
                return;
            }

            System.arraycopy(nums, s1, copyData, s1, e2 - s1);
            System.arraycopy(cnts, s1, copyCnts, s1, e2 - s1);
            int idx = s1;
            while (s1 < e1 && s2 < e2) {
                if (copyData[s1] > copyData[s2]) {
                    copyCnts[s1] += e2 - s2;
                    cnts[idx] = copyCnts[s1];
                    nums[idx++] = copyData[s1++];
                    ans += Math.abs(copyData[s1] - copyData[s2]);
                } else {
                    nums[idx++] = copyData[s2++];
                }
            }

            while (s1 < e1) {
                nums[idx++] = copyData[s1++];
            }
            while (s2 < e2) {
                nums[idx++] = copyData[s2++];
            }

        }
    }
