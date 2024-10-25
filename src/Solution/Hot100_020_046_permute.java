package Solution;

import java.util.LinkedList;
import java.util.List;

public class Hot100_020_046_permute {
    static List<List<Integer>> res = new LinkedList<>();
    public static List<List<Integer>> permute(int[] nums) {
        res.clear();
        backTrace(nums, new LinkedList<>());
        return res;
    }

    public static void backTrace(int[] candidates, LinkedList<Integer> path){
        if (path.size() == candidates.length){
            res.add(new LinkedList<>(path));
        }
        for (int i = 0; i < candidates.length; i++) {
            if (path.contains(candidates[i])){
                continue;
            }
            path.addLast(candidates[i]);
            backTrace(candidates, path);
            path.removeLast();
        }
    }
}
