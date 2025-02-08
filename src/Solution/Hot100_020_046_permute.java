package Solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Hot100_020_046_permute {
//    static List<List<Integer>> res = new LinkedList<>();
//    public static List<List<Integer>> permute(int[] nums) {
//        res.clear();
//        backTrace(nums, new LinkedList<>());
//        return res;
//    }
//
//    public static void backTrace(int[] candidates, LinkedList<Integer> path){
//        if (path.size() == candidates.length){
//            res.add(new LinkedList<>(path));
//        }
//        for (int i = 0; i < candidates.length; i++) {
//            if (path.contains(candidates[i])){
//                continue;
//            }
//            path.addLast(candidates[i]);
//            backTrace(candidates, path);
//            path.removeLast();
//        }
//    }

    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new LinkedList<>();
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int idx) {
        if (idx == nums.length){
            List<Integer> curr = new LinkedList<>();
            for (int num: nums){
                curr.add(num);
            }
            res.add(curr);
            return;
        }

        for (int j = idx; j < nums.length; j++){
            swap(nums, idx, j);
            backtrack(nums, idx+1);
            swap(nums, idx, j);
        }
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
