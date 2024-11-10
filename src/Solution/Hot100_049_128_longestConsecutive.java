package Solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Hot100_049_128_longestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums){
            set.add(num);
        }

        int res = 0;
        for (int num: set){
            if (!set.contains(num-1)){
                int tmp = num;
                while (set.contains(tmp+1)){
                    tmp += 1;
                }

                res = Math.max(res, tmp-num+1);
            }
        }
        return res;
    }
}
