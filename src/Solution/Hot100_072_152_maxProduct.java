package Solution;

public class Hot100_072_152_maxProduct {
    long[] dp_max;
    long[] dp_min;
    public int maxProduct(int[] nums) {
        int n = nums.length;
        dp_max = new long[n];
        dp_min = new long[n];

        dp_min[0] = nums[0];
        dp_max[0] = nums[0];

        for (int i = 1; i < n; i++) {
            dp_max[i] = Math.max(Math.max(nums[i], dp_max[i-1] * nums[i]), dp_min[i-1] * nums[i]);
            dp_min[i] = Math.min(Math.min(nums[i], dp_min[i-1] * nums[i]), dp_max[i-1] * nums[i]);
        }

        int ans = (int) dp_max[0];
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (int) dp_max[i]);
        }
        return ans;
    }
}
