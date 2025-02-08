package Solution;

import java.util.Map;
import java.util.Stack;

public class Hot100_019_042_trap {
    public static int trap(int[] height) {
        if (height == null || height.length < 2){
            return 0;
        }

        int res = 0;
        int l = 0, r = height.length-1;
        int lMax = 0, rMax = 0;
        while (l<r){
            lMax = Math.max(lMax, height[l]);
            rMax = Math.max(rMax, height[r]);
            if (lMax < rMax){
                res += lMax - height[l];
                l++;
            }else {
                res += rMax - height[r];
                r--;
            }
        }
        return res;
    }
}
