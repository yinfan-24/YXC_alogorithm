package Solution;

public class Hot100_089_300_lengthOfLIS {
//    public int lengthOfLIS(int[] nums) {
//        int res = 1;
//        int[] dp = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            dp[i] = 1;
//            for (int j = 0; j < i; j++) {
//                if (nums[j] < nums[i]){
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//            res = Math.max(res, dp[i]);
//        }
//        return res;
//    }

    int len = 1;
    public int lengthOfLIS(int[] nums) {
        int[] d = new int[nums.length];
        d[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > d[len-1]){
                len ++;
                d[len-1] = nums[i];
            }else {
                int k = binarySearch(d, nums[i]);
                d[k+1] = nums[i];
            }
        }
        return len;
    }

    public int binarySearch(int[] d, int target){
        int l = 0, r = len -1;
        while (l <= r){
            int mid = l + (r-l)/2;
            if (d[mid] < target && d[mid+1] >= target) return mid;
            else if (d[mid] < target) {
                l = mid + 1;
            }else {
//               d[mid] > target;
                r = mid - 1;
            }
        }
        return -1;
    }
}
