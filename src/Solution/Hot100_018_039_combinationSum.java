package Solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Hot100_018_039_combinationSum {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res.clear(); // 因为成员变量res是存储在堆中的
        backTrace(candidates, 0, target, new LinkedList<>());
        return res;
    }

    public void backTrace(int[] candidates, int idx, int target, LinkedList<Integer> path){
        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (candidates[i] <= target){
                path.add(candidates[i]);
                backTrace(candidates, i, target-candidates[i], path);
                path.removeLast();
            }
        }
    }

}
