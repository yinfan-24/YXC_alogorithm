package Solution;

import java.util.Arrays;

public class Hot100_072_152_maxProduct {
    int[] dp_max;
    public int maxProduct(int[] nums) {
        dp_max = new int[nums.length];

        dp_max[0] = nums[0];
        int tmp_min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp_max[i] = max(nums[i], nums[i]*dp_max[i-1], nums[i]*tmp_min);
            tmp_min = min(nums[i], nums[i]*dp_max[i-1], nums[i]*tmp_min);
        }

        int res = dp_max[0];
        for (int num: dp_max){
            res = Math.max(res, num);
        }

        return res;
    }

    private static int max(int a, int b, int c){
        return Math.max(a, Math.max(b, c));
    }

    private static int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }
}
