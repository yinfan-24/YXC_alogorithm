package Solution;

public class Hot100_040_101_isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }

    private static boolean helper(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        if (root1.val != root2.val) return false;
        return helper(root1.left, root2.right) && helper(root1.right, root2.left);
    }

}
