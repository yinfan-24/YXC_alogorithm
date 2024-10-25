package Solution;

import java.util.LinkedList;
import java.util.List;

public class Hot100_018_039_combinationSum {

    static List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res.clear();
        backTrace(candidates, 0, target, new LinkedList<>());
        return res;
    }

    public static void backTrace(int[] candidates, int idx, int target, LinkedList<Integer> path){
//        得出解，return
        if (target == 0){
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = idx; i < candidates.length; i++){
            if (candidates[i] <= target){
                path.addLast(candidates[i]);
                backTrace(candidates, i, target - candidates[i], path);
                path.removeLast();
            }

        }

    }
}
