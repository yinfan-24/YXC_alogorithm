package Solution;

import java.time.Year;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Hot100_033_078_subsets {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

    static List<List<Integer>> res;
    public static List<List<Integer>> subsets(int[] nums) {
        res = new LinkedList<>();
        backTrace(nums, 0, new LinkedList<>());
        return res;
    }

    public static void backTrace(int[] nums, int idx, LinkedList<Integer> path){
        res.add(new LinkedList<>(path));
        for (int i = idx; i < nums.length; i++) {
            path.add(nums[i]);
            backTrace(nums, i+1, path);
            path.removeLast();
        }
    }
}
