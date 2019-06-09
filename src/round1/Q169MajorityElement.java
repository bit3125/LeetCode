package round1;

public class Q169MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums==null || nums.length==0)
            return -1;

        int cur = nums[0];
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cnt == 0) {
                cur = nums[i];
                cnt++;
            } else { //cnt>0
                if (cur == nums[i]) {
                    cnt++;
                } else
                    cnt--;
            }
        }

        return cur;
    }
}
