package Solution;

public class Hot100_070_198_rob {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < n; i++) {
            if (i-3 >= 0){
                dp[i] = nums[i] + Math.max(dp[i-2], dp[i-3]);
            }else {
                dp[i] = nums[i] + dp[i-2];
            }
        }
        return Math.max(dp[n-2], dp[n-1]);
    }
}
