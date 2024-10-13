package Solution;
import java.util.Arrays;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Hot100_001_001_twoSum {
    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;
        int[] res = twoSum(nums, target);
        System.out.println(res[0] + " " + res[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] old_arr = nums.clone();
        Arrays.sort(nums);
        int[] res = new int[2];
        int l = 0;
        int r = nums.length-1;
        while (nums[l] + nums[r] != target){
            int tmp = nums[l] + nums[r];
            if (tmp > target) r--;
            else if (tmp < target) {
                l++;
            }
        }
        System.out.println(l + " " + r);
        int res_l = 0, res_r = 0;
        for (int i = 0; i < old_arr.length; i++) {
            if (old_arr[i] == nums[l]){
                res_l = i;
                break;
            }
        }
        for (int i = old_arr.length - 1; i >= 0 ; i--) {
            if (old_arr[i] == nums[r]){
                res_r = i;
                break;
            }
        }
        res[0] = min(res_l, res_r);
        res[1] = max(res_l, res_r);
        return res;
    }
}
