package Solution;

public class Hot100_070_198_rob {
    int[] dp;
    int n;
    public int rob(int[] nums) {
        n = nums.length;
        dp = new int[n];
        if (nums == null) return 0;
        if (n == 1) return nums[0];
        if (n >= 2){
            dp[0] = nums[0];
            dp[1] = nums[1];
        }
//        dp[i]：选择i节点的情况下的最大值
        for (int i = 2; i < n; i++) {
            if (i - 3 >= 0){
                dp[i] = nums[i] + Math.max(dp[i-3], dp[i-2]);
            }else {
                dp[i] = nums[i] + dp[i-2];
            }

        }
        return Math.max(dp[n-2], dp[n-1]);
    }
}
