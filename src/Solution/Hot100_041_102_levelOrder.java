package Solution;

import java.util.*;

public class Hot100_041_102_levelOrder {
    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {
        res = new LinkedList<>();
        recursion(root, 0);
        return res;
    }

    private void recursion(TreeNode root, int deep){
        if (root == null) return;

        deep++;
        if (res.size() < deep){
            List<Integer> item = new LinkedList<>();
            res.add(item);
        }
        res.get(deep-1).add(root.val);
        recursion(root.left, deep);
        recursion(root.right, deep);
    }
}
