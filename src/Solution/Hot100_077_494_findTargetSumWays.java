package Solution;


import java.util.Arrays;

public class Hot100_077_494_findTargetSumWays {

    public int findTargetSumWays(int[] nums, int target) {
        int pos = 0;        // 正数集合的和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int tmp = target + sum;
        if (tmp < 0 || tmp % 2 != 0) return 0;
        pos = tmp / 2;

        int[] dp = new int[pos + 1];
        dp[0] = 1;
        // 为什么是从后往前推的？
        for (int num: nums) {     // 物品个数
            for (int j = pos; j >= num; j--) {   // 背包容量
                dp[j] += dp[j-num];
            }
        }
        return dp[pos];
    }


}
