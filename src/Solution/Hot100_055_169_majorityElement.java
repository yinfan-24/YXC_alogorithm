package Solution;

import java.util.HashMap;

public class Hot100_055_169_majorityElement {
    public int majorityElement(int[] nums) {
        return quickSelect(nums, nums.length/2+1,0, nums.length-1);
    }

    private static int quickSelect(int[] nums, int k, int begin, int end){
        if (begin >= end) return nums[begin];
        int ref = nums[begin+end >> 1];
        int l = begin-1, r = end+1;
        while (l < r){
            while (nums[++l] < ref);
            while (nums[--r] > ref);
            if (l < r){
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
            }
        }
        int len = r-begin+1;
        if (len >= k) return quickSelect(nums, k, begin, r);
        else return quickSelect(nums, k-len, r+1, end);
    }
}
