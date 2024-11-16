package Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hot100_060_448_findDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int num : nums) {
            nums[ (num-1) % n] += n;
        }
        for (int i = 0; i < n; i++) {
//            因为i不能超过下标，所以存储的是i-1是否存在，而不是直接存储i
            if (nums[i] <= n){
                res.add(i+1);
            }
        }
        return res;
    }
}
