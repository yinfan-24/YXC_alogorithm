package Solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Hot100_049_128_longestConsecutive {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int num: nums) set.add(num);
        for (int num: set){
            if (!set.contains(num-1)){
                int cnt = 1;
                while (set.contains(num+cnt)) cnt++;
                res = Math.max(res, cnt);
            }
        }
        return res;
    }
}
