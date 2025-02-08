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

        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return result;

        Arrays.sort(nums);

        int len = nums.length;
        for (int i = 0; i < len-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int target = 0-nums[i];
            int j = i+1, k = len-1;
            while (j < k){
                if (nums[j] + nums[k] == target){
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
//                    跳过重复的结果
                    while (j < k && nums[j] == nums[j+1]) j++;
                    while (j < k && nums[k] == nums[k-1]) k--;
                    j++; k--;
                } else if (nums[j] + nums[k] < target){
                    j++;
                } else {
                    k--;
                }
            }

        }

        return result;
    }
}
