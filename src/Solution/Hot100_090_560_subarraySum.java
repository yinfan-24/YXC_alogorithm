package Solution;

import java.util.HashMap;

public class Hot100_090_560_subarraySum {
//    public int subarraySum(int[] nums, int k) {
//        int count = 0;
//        for (int end = 0; end < nums.length; end++) {
//            int sum = 0;
//            for (int start = end; start >= 0 ; start--) {
//                sum += nums[start];
//                if (sum == k) count++;
//            }
//        }
//        return count;
//    }

    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 1; i < nums.length; i++) {
            pre += nums[i];
            count += map.getOrDefault(pre - k, 0);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
