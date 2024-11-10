package Solution;

import java.util.HashMap;

public class Hot100_055_169_majorityElement {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            if (map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else {
                map.put(num, 1);
            }
            if (map.get(num) > (n+1)/2) return map.get(num);
        }
        return 0;
    }
}
