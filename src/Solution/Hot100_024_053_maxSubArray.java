package Solution;

public class Hot100_024_053_maxSubArray {
    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {

        int res = Integer.MIN_VALUE;
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
        }
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
