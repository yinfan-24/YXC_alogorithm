package Solution;

public class Hot100_047_543_diameterOfBinaryTree {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root){
        if (root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        res = Math.max(l + r, res);
        return Math.max(l, r) + 1;
    }
}
