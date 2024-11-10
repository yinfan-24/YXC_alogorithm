package Solution;

import java.util.Arrays;
import java.util.Collections;

public class Hot100_048_581_findUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length <= 1) return 0;
        int n = nums.length;

        int l = n - 1;
        int n_min = nums[l];
        for (int i = n-1; i >= 0 ; i--) {
            if (nums[i] < n_min) {
                n_min = nums[i];
            }else {
                l = i;
            }
        }

        int r = 0;
        int n_max = nums[r];
        for (int i = 0; i < n; i++) {
            if (nums[i] > n_max){
                n_max = nums[i];
            }else {
                r = i;
            }
        }
        if (l == n-1 && r == 0) return 0;
        return r - l + 1;
    }
}
