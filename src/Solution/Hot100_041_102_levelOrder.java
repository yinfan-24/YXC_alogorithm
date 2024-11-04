package Solution;

import java.util.*;

public class Hot100_041_102_levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.EMPTY_LIST;

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode top = queue.poll();
                list.add(top.val);
                if (top.left != null) queue.offer(top.left);
                if (top.right != null) queue.offer(top.right);
            }
            res.add(list);
        }
        return res;
    }
}
