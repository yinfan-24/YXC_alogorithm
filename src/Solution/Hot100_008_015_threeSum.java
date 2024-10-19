package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hot100_008_015_threeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = new ArrayList<>();
        res = threeSum(nums);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.print("\n");
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i>0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i+1, k = nums.length-1; j < k; j++) {
                if (j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                while (j < k - 1 && nums[i] + nums[j] + nums[k-1] >= 0){
                    k --;
                }
                if (nums[i] + nums[j] + nums[k] == 0){
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }
        return res;
    }
}
