package round2.Q001TowSum.solution1;

import java.util.Arrays;
import java.util.Comparator;

class Solution {

    class Pair{

        int idx;
        int value;

        public Pair (int idx, int value){
            this.idx = idx;
            this.value = value;
        }
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums==null || nums.length==0)
            return null;

        int[] result = new int[2];
        Pair[] pairArr = new Pair[nums.length];
        for (int i = 0; i < pairArr.length; i++) {
            Pair curPair = new Pair(i, nums[i]);
            pairArr[i] = curPair;
        }
        Arrays.sort(pairArr, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Integer.compare(o1.value, o2.value);
            }
        });

        int front = 0, rear = pairArr.length-1 , sum = 0;
        while (front < rear) {
            sum = pairArr[front].value + pairArr[rear].value;
            if (sum < target) {
                front++;
            } else if (sum > target) {
                rear--;
            } else {
                result[0] = pairArr[front].idx;
                result[1] = pairArr[rear].idx;
                return result;
            }
        }
        return null; // never arive
    }
}