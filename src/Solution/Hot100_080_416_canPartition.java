package Solution;

import java.util.Arrays;

public class Hot100_080_416_canPartition {
    public boolean canPartition(int[] nums) {
//        数组长度不超过2，则不可分
        int n = nums.length;
        if (n < 2) return false;

//        数组元素的和为奇数，则不可分
        int sum = 0;
        int maxNum = nums[0];
        for (int num: nums) {
            sum += num;
            maxNum = Math.max(num, maxNum);
        }
        if (sum % 2 != 0) return false;

//        最大元素已经超过和的一半则不可分
        int target = sum / 2;
        if (maxNum > target) return false;

//        dp[i][j] 选取0-i的下标元素，能达到j的可能性
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) dp[i][0] = true;
        dp[0][nums[0]] = true;

        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target ; j++) {
                if (j >= num){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - num];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n-1][target];
    }
}
