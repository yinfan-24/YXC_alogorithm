package Solution;

public class Hot100_046_124_maxPathSum {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root){
        if (root == null) return 0;
        int lMax = Math.max(0, dfs(root.left));
        int rMax = Math.max(0, dfs(root.right));

        res = Math.max(res, lMax+rMax+root.val);
        return Math.max(lMax, rMax) + root.val;
    }

}
