package Solution;

public class Hot100_023_053_maxSubArray {
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int res = nums[0];
        for (int num : nums) {
            pre = Math.max(pre+num, num);
            res = Math.max(res, pre);
        }

        return res;
    }
}
