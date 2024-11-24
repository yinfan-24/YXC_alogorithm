package Solution;

public class Hot100_071_238_productExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];
        res[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            res[i] = res[i+1] * nums[i];
        }

        res[0] = res[1];
        int cnt = nums[0];
        for (int i = 1; i < n; i++) {
            if (i < n-1){
                res[i] = cnt * res[i+1];
            }else {
                res[n-1] = cnt;
            }
            cnt *= nums[i];
        }
        return res;
    }
}
