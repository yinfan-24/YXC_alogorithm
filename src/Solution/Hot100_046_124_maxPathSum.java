package Solution;

public class Hot100_046_124_maxPathSum {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root){
        if (root == null) return 0;
        int l = Math.max(0, dfs(root.left));
        int r = Math.max(0, dfs(root.right));

        res = Math.max(res, l + r + root.val);
        return Math.max(l, r) + root.val;

    }
}
